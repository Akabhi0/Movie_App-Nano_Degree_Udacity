package com.example.aka.moview_app;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AKA on 9/16/2017.
 */

public class Adapter_Movie_Data extends RecyclerView.Adapter<Adapter_Movie_Data.Movie_data_holder> {

    ArrayList<Movie_Data> movie_datas;
    Context context;
    String poster_url = "http://image.tmdb.org/t/p/w185/";
    String title;

    public Adapter_Movie_Data(ArrayList<Movie_Data> movie_datas, MainActivity mainActivity) {
        this.movie_datas = movie_datas;
        context = mainActivity;
    }

    @Override
    public int getItemCount() {
        return movie_datas.size();
    }

    @Override
    public Movie_data_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_data_adapter,null);
        return new Movie_data_holder(view);
    }


    @Override
    public void onBindViewHolder(Movie_data_holder holder, final int position) {

        title = movie_datas.get(position).getTitle();
        holder.textView.setText(title);
        String poster_image = poster_url+movie_datas.get(position).getPoster();
        Picasso.with(context).load(poster_image).into(holder.imageView);

    }

    class Movie_data_holder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;

        public Movie_data_holder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.movie_data);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Movie_Info.class);
                    intent.putExtra("data",movie_datas.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
