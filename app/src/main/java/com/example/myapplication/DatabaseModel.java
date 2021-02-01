package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseModel extends SQLiteOpenHelper {
    public static final String stud_name = "name";
    public static final String stud_roll = "roll";
    public static final String stud_age = "age";
    public static final String stud_phone = "phone";
    public static final String stud_table = "stable";



    public DatabaseModel(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatable = "create table "+stud_table+" ("+stud_name+" VARCHAR(20), "+stud_roll+" INT, "+stud_age+" INT, "+stud_phone+" INT)";
        db.execSQL(creatable);
    }


    public boolean add(studentModel stud)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(stud_name,stud.getName());
        cv.put(stud_roll,stud.getRoll());
        cv.put(stud_age,stud.getAge());
        cv.put(stud_phone,stud.getPhone());
        long insert = db.insert(stud_table, null,cv);
        if (insert == 1)
        {
            return true;
        }
        else
            return false;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + stud_table, null);
        return res;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
