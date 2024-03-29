package com.example.dhvanil.attendencecounter.DataBaseClass;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataBaseHelperForDate extends SQLiteOpenHelper
{
    public DataBaseHelperForDate( Context context) {
        super( context, "yeah", null, 1);
    }
    @Override
    public void onCreate( SQLiteDatabase db ) {
        db.execSQL("CREATE TABLE DATESHEET(DATE1 TEXT)");
    }
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL( "DROP TABLE IF EXISTS DATESHEET");
    }
    public boolean insert(String DATE)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE1",DATE);
        long indicator = db.insert("DATESHEET",null,contentValues);
        if(indicator==-1)
            return false;
        else return true;
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
    public boolean replace(String DATE,boolean Varified){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "DATE1",DATE);
        long a=database.replace("DATESHEET",null,contentValues);
        if(a==-1)
            return false;
        else
            return true;
    }
    public Cursor Select(String date){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = (Cursor) database.rawQuery( "SELECT * FROM DATESHEET where DATE1="+date+"",null);
        return  cursor;
    }
    public boolean Update(String Date){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "DATE1",Date);
        long a= database.update( "DATESHEET",contentValues,"DATE1='"+Date+"'",null);
        if(a==-1){
            return false;
        }
        else
        {
            return true;
        }
    }
}
