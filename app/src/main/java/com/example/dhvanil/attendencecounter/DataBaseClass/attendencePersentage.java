package com.example.dhvanil.attendencecounter.DataBaseClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class attendencePersentage extends SQLiteOpenHelper {
    public attendencePersentage( Context context) {
        super(context,"Nothing",null,1);
    }
    @Override
    public void onCreate( SQLiteDatabase db ) {
        db.execSQL( "CREATE TABLE ATTENDENCE(SUBNAME TEXT PRIMARY KEY,TOTAL INTEGER,GOT INTEGER)");
    }
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("DROP TABLE IF EXISTS ATTENDENCE");
    }
    public boolean insert(String SUBNAME,int Total,int Got){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "SUBNAME", SUBNAME);
        contentValues.put( "TOTAL",Total);
        contentValues.put("GOT",Got);
        long indicator = database.insert( "ATTENDENCE",null,contentValues);
        if(indicator==-1){
            return  false;
        }
        else return true;
    }
    public Cursor GetData(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery( "SELECT * FROM ATTENDENCE",null );
        return  cursor;
    }
    public void delete(String SUB){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL( "DELETE FROM ATTENDENCE WHERE SUBNAME='"+SUB+"'");
    }
    public void deleteALL()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL( "DELETE FROM ATTENDENCE");
    }
    public boolean replace(String SUBNAME,int Total,int Got){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put("SUBNAME",SUBNAME);
        contentValues.put("TOTAL",Total);
        contentValues.put("GOT",Got);
        long a = database.replace("ATTENDENCE",null,contentValues);
        if(a==-1){
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor Select(String SUBNAME){
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor = database.rawQuery( "SELECT * FROM ATTENDENCE WHERE SUBNAME='"+SUBNAME+"'",null);
        return cursor;
    }
}
