package application;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

import com.google.gson.Gson;
import entities.*;


public class App {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Company Name: "); //Personal preference: Warner Bros Animation
        String input = read.nextLine();
        //colocar return 0, caso o nome da companhia nao existir

        try {
            String jsonID = new HttpApiClient().getID(input);

            String companyID = new Gson().fromJson(jsonID, Results.class).getFirstResultID(); //Company ID found!
            String companyName = new Gson().fromJson(jsonID, Results.class).getFirstResultName(); //Company name found!

            String json = new HttpApiClient().getBody(companyID); // Return all movies and series by Company name

            Items items = new Gson().fromJson(json, Items.class); //convert json to java object
            items.getContent().sort(Comparator.reverseOrder()); //descending order by year

            PrintWriter writer = new PrintWriter("content.html");
            new HTMLGenerator().generate(writer, items.getContent(), companyName); //generate html content
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
