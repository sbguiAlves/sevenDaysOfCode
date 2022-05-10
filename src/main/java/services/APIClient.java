package services;

public interface APIClient {
    String getBody(String companyID);
    String getID(String companyName);
    String getApiKey();
}
