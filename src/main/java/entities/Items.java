package entities;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import services.Content;
import services.JsonParser;

public class Items implements JsonParser {
    @SerializedName("id")
    @Expose
    String companyId;
    @SerializedName("items")
    @Expose
    private final List<Movie> contentList = new ArrayList<>();

    @Override
    public List<? extends Content> getContent() {
        return contentList;
    }

    @Override
    public String toString() {
        return String.format("Company ID: %s, Items: %s", companyId, contentList);
    }
}

class Movie implements Content {
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("year")
    @Expose
    String year;
    @SerializedName("image")
    @Expose
    String image;
    @SerializedName("imDbRating")
    @Expose
    String rating;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getRating() {
        if(rating.equals("-"))
        {
            return "N/A";
        }

        return rating;
    }
    @Override
    public String toString() {
        return String.format("Title: %s, Year: %s, Rating: %s\n", title, year, rating);
    }

    @Override
    public int compareTo(Content outro) {
        return this.getYear().compareTo(outro.getYear());
    }

}

//Outras classes também pra Série, HQ, etc...