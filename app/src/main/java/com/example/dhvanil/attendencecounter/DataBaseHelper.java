package com.example.dhvanil.attendencecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.dhvanil.attendencecounter.ApplicationClass.hp;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper( Context context,String name) {
        super(context,name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL( "CREATE TABLE TIMETABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT,LEC1 TEXT,LEC2 TEXT,LEC3 TEXT,LEC4 TEXT,LEC5 TEXT,LEC6 TEXT);");
    }

    @Override

    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("DROP TABLE IF EXISTS TIMETABLE");
        onCreate(db);
    }

    public boolean insert(String L1,String L2,String L3,String L4,String L5,String L6)
    {
        hp.deleteAll();
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("LEC1",L1);
        contentValues.put("LEC2",L2);
        contentValues.put("LEC3",L3);
        contentValues.put("LEC4",L4);
        contentValues.put("LEC5",L5);
        contentValues.put("LEC6",L6);
        long indicator = db.insert( "TIMETABLE",null,contentValues);
        if(indicator==-1){
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor GetData()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery( "SELECT * FROM TIMETABLE",null );
        return  cursor;
    }
    public  void delete(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL( "DELETE FROM TIMETABLE WHERE ID="+id);
    }
    public void deleteAll()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM TIMETABLE");
    }
}
