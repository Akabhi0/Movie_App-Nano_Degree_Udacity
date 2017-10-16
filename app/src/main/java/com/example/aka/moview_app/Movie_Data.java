package com.example.aka.moview_app;

import java.io.Serializable;

/**
 * Created by AKA on 9/16/2017.
 */

public class Movie_Data implements Serializable {
    String title;
    String poster;
    String overview;

    public String getOverview() {
        return overview;
    }

    String poster_path;
    int release_date;
    double popularity;
    double vote_average;
    int PERSON_NUMBER;

    public String getPoster_path() { return poster_path; }

    public int getRelease_date() {
        return release_date;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }
}
