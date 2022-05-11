package application;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

import com.google.gson.Gson;
import entities.*;


public class App {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("API Key: ");
        String apiKey = read.nextLine();

        System.out.println("Company Name: "); //example: Warner Bros Animation, A24, disney
        String companyName = read.nextLine();

        try {
            String jsonID = new HttpApiClient().getID(companyName, apiKey);

            String companyID = new Gson().fromJson(jsonID, Results.class).getFirstResultID(); //Company ID found!
            String result = new Gson().fromJson(jsonID, Results.class).getFirstResultName(); //Company name found!

            String json = new HttpApiClient().getBody(companyID, apiKey); // Return all movies and series by Company name

            Items items = new Gson().fromJson(json, Items.class); //convert json to java object
            items.getContent().sort(Comparator.reverseOrder()); //descending order by year

            PrintWriter writer = new PrintWriter("productionByCompany.html");
            new HTMLGenerator().generate(writer, items.getContent(), result); //generate html content
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
