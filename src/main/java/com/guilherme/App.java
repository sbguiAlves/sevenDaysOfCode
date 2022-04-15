package com.guilherme;

import java.net.URI;
import java.net.http.*;
import com.google.gson.Gson;


public class App {
    public static void main(String[] args) throws Exception {
        String apiKey = "k_5djxoj5o";
        URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Items items = new Gson().fromJson(response.body(), Items.class);

            if (items != null) {
                for (Movie mov : items.getMovies()) {
                    System.out.format("%s" + " (%d)" + " - Nota: %.1f\n", mov.getTitle(), mov.getYear(),
                            mov.getRating());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
