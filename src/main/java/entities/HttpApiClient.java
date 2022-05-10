package entities;

import services.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class HttpApiClient implements APIClient {

    public String getID(String companyName)
    {
        String str = (companyName.replaceAll("\\s+","")).toLowerCase();

        try {
            String apiKey = getApiKey(); // API Imdb
            URI apiIMDB = URI.create(String.format("https://imdb-api.com/en/API/SearchCompany/%s/%s", apiKey, str)); // Search by Company ID

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public String getBody(String companyID) {

        try {
            String apiKey = getApiKey(); // API Imdb
            URI apiIMDB = URI.create(String.format("https://imdb-api.com/en/API/Company/%s/%s", apiKey, companyID)); // Search by Company

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getApiKey()
    {
        return "k_5djxoj5o";
    }

}
