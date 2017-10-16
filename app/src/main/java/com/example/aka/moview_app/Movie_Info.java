package com.example.aka.moview_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Movie_Info extends AppCompatActivity {

    TextView rating,title,overview,overview_info;
    ImageView show_image;
    Button play,list,offline;
    String poster_url = "http://image.tmdb.org/t/p/w185/";
    Movie_Data movie_data;
    SQL_Database sql_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__info);
        sql_database = new SQL_Database(this);
        init();
    }

    public void init(){

        play = (Button) findViewById(R.id.play);
        list = (Button) findViewById(R.id.see_list);
        offline  = (Button) findViewById(R.id.offiline);
        rating = (TextView) findViewById(R.id.rating);
        title = (TextView) findViewById(R.id.title);
        overview = (TextView) findViewById(R.id.overview);
        overview_info = (TextView) findViewById(R.id.overview_info);
        show_image = (ImageView) findViewById(R.id.show_image);


        Intent intent = getIntent();
        movie_data = (Movie_Data) intent.getSerializableExtra("data");
        //this is we are getting the data
        title.setText(movie_data.getTitle());
        overview_info.setText(movie_data.getOverview());
        String popularity = String.valueOf(movie_data.getPopularity());
        overview.setText(popularity);
        String vote_average = String.valueOf(movie_data.getVote_average());
        rating.setText(vote_average);

        if(movie_data.PERSON_NUMBER == 1)
            Picasso.with(this).load(poster_url+movie_data.getPoster_path()).into(show_image);
        else if(movie_data.PERSON_NUMBER == 2)
            Picasso.with(this).load(poster_url+movie_data.getPoster_path()).into(show_image);
        else if(movie_data.PERSON_NUMBER == 3)
            Picasso.with(this).load(poster_url+movie_data.getPoster_path()).into(show_image);
        else
            Picasso.with(this).load(poster_url+movie_data.getPoster()).into(show_image);

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql_database.Insert(movie_data.getTitle(),movie_data.getPoster(),movie_data.getVote_average());
            }
        });

        list.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Movie_Info.this,List_movie_data_saved.class);
                startActivity(intent1);
            }
        });

    }
}
