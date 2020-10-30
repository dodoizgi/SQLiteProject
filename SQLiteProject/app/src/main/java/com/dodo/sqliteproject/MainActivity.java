package com.dodo.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try{

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY ,name VARCHAR , age INT)");

           // database.execSQL("INSERT INTO musicians (name , age) VALUES('James',50)");
           //database.execSQL("INSERT INTO musicians (name , age) VALUES('bor',20)");
           // database.execSQL("INSERT INTO musicians (name , age) VALUES('dada',36)");

           // database.execSQL("UPDATE musicians SET age = 61 WHERE name = 'James'");
           // database.execSQL("UPDATE musicians SET name = 'boraaaaa' WHERE id = 2");
           // database.execSQL("DELETE FROM musicians WHERE id =2");



            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'JAMES'",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'd%'",null);

            Cursor cursor = database.rawQuery("SELECT * FROM musicians",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){

                System.out.println("Name : "+cursor.getString(nameIx));
                System.out.println("Age : "+cursor.getInt(ageIx));
                System.out.println("Id : "+cursor.getInt(idIx));

            }
            cursor.close();

        }catch(Exception e){

            e.printStackTrace();;
        }
    }




}
