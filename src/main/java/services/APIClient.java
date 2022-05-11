package services;

public interface APIClient {
    String getBody(String companyID, String apiKey);
    String getID(String companyName, String apiKey);
}
