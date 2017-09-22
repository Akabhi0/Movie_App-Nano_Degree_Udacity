package com.example.aka.moview_app;

import java.io.Serializable;

/**
 * Created by AKA on 9/16/2017.
 */

public class Movie_Data implements Serializable {
    String title;
    String poster;
    int release_date;

    public int getRelease_date() {
        return release_date;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getVote_average() {
        return vote_average;
    }

    int popularity;
    int vote_average;


    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }
}
