package com.example.aka.moview_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AKA on 10/12/2017.
 */

public class SQL_Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movie_data.db";
    private static final String TABLE_NAME = "movie_data";
    SQLiteDatabase sqLiteDatabase;
    Context context;
    Save_data save_data;
    List_movie_data_saved list_movie_data_saved;

    public SQL_Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,TITLE TEXT,POSTER TEXT ,RATING REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void Insert(String title,String poster,double rating){

        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("TITLE",title);
        contentValues.put("POSTER",poster);
        contentValues.put("RATING",rating);

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //Log.e("data_saved", String.valueOf(contentValues));
        Toast.makeText(context,"Data Save Offline",Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Save_data> data_show(){

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,"ID DESC");
        ArrayList<Save_data> save_datas = new ArrayList<>();

        while (cursor.moveToNext()){

            save_data = new Save_data(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3)
            ) ;
            save_datas.add(save_data);
        }
        cursor.close();
        return  save_datas;
    }


    public void Delete(){

    }

    public void Select(){

    }

    public void Update(){

    }
}
