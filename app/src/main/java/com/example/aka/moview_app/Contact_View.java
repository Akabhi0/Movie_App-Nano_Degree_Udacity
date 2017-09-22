package com.example.aka.moview_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_View extends AppCompatActivity {

    TextView name,nick,info;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__view);
        init();
    }

    public void init(){

        name = (TextView) findViewById(R.id.name);
        nick = (TextView) findViewById(R.id.nick);
        info = (TextView) findViewById(R.id.info);
        imageView = (ImageView) findViewById(R.id.image_view);

        imageView.setImageResource(R.drawable.itachi);
        name.setText("Abhishek Kr. Abhi");
        nick.setText("abhishekabhi0@gmail.com");
        info.setText("The lazy and comedy one, Ready for party everytime cation!(depends on money) " +
                    "Big football fan and always willing to put jokes ,its nice to everyone");


    }
}
