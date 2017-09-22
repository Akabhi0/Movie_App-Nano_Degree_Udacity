package com.example.aka.moview_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Movie_Info extends AppCompatActivity {

    TextView rating,title,overview;
    ImageView show_image;
    String poster_url = "http://image.tmdb.org/t/p/w185/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__info);
        init();
    }

    public void init(){
        rating = (TextView) findViewById(R.id.rating);
        title = (TextView) findViewById(R.id.title);
        overview = (TextView) findViewById(R.id.overview);
        show_image = (ImageView) findViewById(R.id.show_image);


        Intent intent = getIntent();
        String title_movie  = intent.getStringExtra("data");
        String poster = intent.getStringExtra("poster");

        //this is we are getting the data
        title.setText(title_movie);
        Picasso.with(this).load(poster_url+poster).into(show_image);
    }
}
