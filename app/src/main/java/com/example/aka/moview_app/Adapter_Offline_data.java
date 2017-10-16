package com.example.aka.moview_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by AKA on 10/15/2017.
 */

public class Adapter_Offline_data extends RecyclerView.Adapter<Adapter_Offline_data.View_Holder> {

    ArrayList<Save_data> save_datas;
    Context context;
    String poster_url = "http://image.tmdb.org/t/p/w185/";

    public Adapter_Offline_data(ArrayList<Save_data> save_datas, List_movie_data_saved list_movie_data_saved) {
        this.save_datas = save_datas;
        this.context = list_movie_data_saved;
    }

    @Override
    public int getItemCount() {
        return save_datas.size();
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_data_save,null);
        return new View_Holder(view);

    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        holder.title.setText(save_datas.get(position).getTitle());
        String rating = String.valueOf(save_datas.get(position).getRating());
        holder.rating.setText(rating);
        Picasso.with(context).load(poster_url+save_datas.get(position).getPoster()).into(holder.imageView);
    }

    class View_Holder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView title,rating;

        public View_Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_circle);
            title = itemView.findViewById(R.id.title_save);
            rating = itemView.findViewById(R.id.rating_save);
        }
    }

}
