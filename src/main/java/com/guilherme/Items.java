package com.guilherme;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("items")
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

class Movie {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    String image;
    @SerializedName("imDbRating")
    @Expose
    float rating;
    @SerializedName("year")
    @Expose
    int year;

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
