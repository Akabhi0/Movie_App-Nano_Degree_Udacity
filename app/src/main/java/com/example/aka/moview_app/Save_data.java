package com.example.aka.moview_app;

/**
 * Created by AKA on 10/15/2017.
 */

public class Save_data {

    Double rating;
    String title,poster;

    public Save_data(String title, String poster, double rating) {
        this.rating = rating;
        this.title = title;
        this.poster = poster;
    }

    public Double getRating() {
        return rating;
    }

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }
}
