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
        db.execSQL("CREATE TABLE DATESHEET(DATE1 DATE PRIMARY KEY,VARIFIED BOOLEAN)");
    }
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL( "DROP TABLE IF EXISTS DATESHEET");
    }
    public boolean insert(String DATE,boolean Varified)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE1",DATE);
        contentValues.put( "VARIFIED",Varified);
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
    public boolean replace(String DATE,boolean Varified){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( "DATE1",DATE);
        contentValues.put( "VARIFIED",Varified);
        long a =database.replace("DATESHEET",null,contentValues);
        if(a==-1){
            return false;
        }
        else
        {
            return true;
        }

    }
}
