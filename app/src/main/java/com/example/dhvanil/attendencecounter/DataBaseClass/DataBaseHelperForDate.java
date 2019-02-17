package com.example.dhvanil.attendencecounter.DataBaseClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelperForDate extends  SQLiteOpenHelper{


    public DataBaseHelperForDate( Context context) {
        super( context, "yeah", null, 1);
    }

    @Override
    public void onCreate( SQLiteDatabase db ) {
        db.execSQL("CREATE TABLE DATESHEET(DATE1 DATE,LEC1 INTTEGER,LEC2 INTEGER,LEC3 INTEGER,LEC4 INTEGER,LEC5 INTEGER,LEC6 INTEGER)");
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL( "DROP TABLE IF EXISTS DATESHEET" );
    }
    public boolean insert(String DATE,String s1,String s2,String s3,String s4,String s5,String s6)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "DATE1",DATE);
        contentValues.put("LEC1",s1);
        contentValues.put("LEC2",s2);
        contentValues.put("LEC3",s3);
        contentValues.put("LEC4",s4);
        contentValues.put("LEC5",s5);
        contentValues.put("LEC6",s6);
        long indicator = db.insert("DATESHEET",null,contentValues);
        if(indicator==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor GetData(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery( "SELECT * FROM DATESHEET",null );
        return  cursor;
    }
    public void delete(String DATE){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL( "DELETE FROM DATESHEET WHERE DATE1="+DATE);
    }
    public void deleteALL()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL( "DELETE FROM DATESHEET");
    }
}
