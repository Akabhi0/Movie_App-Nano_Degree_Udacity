package com.example.aka.moview_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapter_Movie_Data adapter;
    RecyclerView recyclerview;
    String api = "cee3ed8bcc95b48954b430b27df3b42c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recycle_view);
        init_person();
    }

    public void init_person(){
        String url = "https://api.themoviedb.org/3/person/popular?api_key="+api;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //now sending the response to the brouser
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                JsonObjectRequest.Method.GET,
                url,
                null,
                new MyJSONObjectListener_person(),
                new MyErrorListener()
        );
        requestQueue.add(jsonObjectRequest);
    }

    public void init_movie(){
        //to make a request from the internet we are using google volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+api;

        //Now sending the request to the request to the brouser
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                JsonObjectRequest.Method.GET,
                url,
                null,
                new MyJSONObjectListener(),
                new MyErrorListener()
        );
       requestQueue.add(jsonObjectRequest);
    }

    public void init_tv(){
        String url = "https://api.themoviedb.org/3/tv/top_rated?api_key="+api;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //now sending the response to the brouser
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                JsonObjectRequest.Method.GET,
                url,
                null,
                new MyJSONObjectListener_tv(),
                new MyErrorListener()
        );
        requestQueue.add(jsonObjectRequest);
    }

    class MyJSONObjectListener implements Response.Listener<JSONObject> {
        @Override
        public void onResponse(JSONObject response) {
            try {

                JSONArray jsonArray = response.getJSONArray("results");
                ArrayList<Movie_Data> movie_datas = new ArrayList<>();

                for(int i=0; i<=jsonArray.length() ;i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Movie_Data movieData = new Movie_Data();
                    movieData.title = jsonObject.getString("original_title");
                    movieData.poster = jsonObject.getString("poster_path");

                    movie_datas.add(movieData);
                    //now we are going to set the recycler view
                    adapter = new Adapter_Movie_Data(movie_datas,MainActivity.this);
                    recyclerview.setAdapter(adapter);

                    GridLayoutManager gridlayoutmanager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerview.setLayoutManager(gridlayoutmanager);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class MyJSONObjectListener_tv implements Response.Listener<JSONObject> {
        @Override
        public void onResponse(JSONObject response) {
            try {

                JSONArray jsonArray = response.getJSONArray("results");
                ArrayList<Movie_Data> movie_datas = new ArrayList<>();

                for(int i=0; i<=jsonArray.length() ;i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Movie_Data movieData = new Movie_Data();
                    movieData.title = jsonObject.getString("original_name");
                    movieData.poster = jsonObject.getString("poster_path");

                    movie_datas.add(movieData);
                    //now we are going to set the recycler view
                    adapter = new Adapter_Movie_Data(movie_datas,MainActivity.this);
                    recyclerview.setAdapter(adapter);

                    GridLayoutManager gridlayoutmanager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerview.setLayoutManager(gridlayoutmanager);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class MyJSONObjectListener_person implements Response.Listener<JSONObject> {
        @Override
        public void onResponse(JSONObject response) {
            try {

                JSONArray jsonArray = response.getJSONArray("results");
                ArrayList<Movie_Data> movie_datas = new ArrayList<>();

                for(int i=0; i<=jsonArray.length() ;i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Movie_Data movieData = new Movie_Data();
                    movieData.title = jsonObject.getString("name");
                    movieData.poster = jsonObject.getString("profile_path");

                    movie_datas.add(movieData);
                    //now we are going to set the recycler view
                    adapter = new Adapter_Movie_Data(movie_datas,MainActivity.this);
                    recyclerview.setAdapter(adapter);

                    GridLayoutManager gridlayoutmanager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerview.setLayoutManager(gridlayoutmanager);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



    class MyErrorListener implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(MainActivity.this,"the net is not wordking",Toast.LENGTH_SHORT).show();
        }
    }

 //creating custom menu in main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Popular_One:
                init_movie();
                break;
            case R.id.Recent_One:
                init_tv();
                break;
            case R.id.contact:
                Intent intent = new Intent(MainActivity.this,Contact_View.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
