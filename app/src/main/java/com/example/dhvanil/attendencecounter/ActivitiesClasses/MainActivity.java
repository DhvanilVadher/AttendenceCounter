package com.example.dhvanil.attendencecounter.ActivitiesClasses;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhvanil.attendencecounter.DataBaseClass.DataBaseHelper;
import com.example.dhvanil.attendencecounter.DataBaseClass.DataBaseHelperForDate;
import com.example.dhvanil.attendencecounter.DataBaseClass.attendencePersentage;
import com.example.dhvanil.attendencecounter.R;
import com.example.dhvanil.attendencecounter.DataBaseClass.TinyDB;
import com.example.dhvanil.attendencecounter.adaptersClasses.List;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.Startdate;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.Todaydate;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.hp;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.hpd;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.APT;

public class MainActivity extends AppCompatActivity
{
    public String startingDate,todaysDate;
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        hp = new DataBaseHelper(this,"Yeah" );
        hpd = new DataBaseHelperForDate(this);
        setContentView( R.layout.activity_main);
        initialization();
        checkCondition();
    }
    private void checkCondition() {
        if(startingDate=="" || startingDate == null){
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder( this );
            final EditText input = new EditText( this );
            input.setInputType( InputType.TYPE_DATETIME_VARIATION_DATE);
            builder.setView( input );
            builder.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick( DialogInterface dialog, int which ) {
                    startingDate =input.getText().toString();
                    Toast.makeText( MainActivity.this,startingDate,Toast.LENGTH_LONG ).show();
                    todaysDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    Startdate= LocalDate.parse(startingDate,formatter);
                    TinyDB tinyDB = new TinyDB(MainActivity.this);
                    tinyDB.putString( "StartingDate",startingDate);
                    Todaydate = LocalDate.parse(todaysDate,formatter);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick( DialogInterface dialog, int which ) {
                    dialog.cancel();
                }
            } );
            builder.show();
        }
    }
    private void initialization(){
        TinyDB tinyDB = new TinyDB( this );
        startingDate= tinyDB.getString("StartingDate");
        APT= new attendencePersentage(this);
    }
    public void about(View view){
    }
    public void showAttendence( View view ) {
        Cursor cursor = hp.GetData();
        Log.v("what","Data for First");
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast())
            {
                Log.v("what",cursor.getString(1) + " " +cursor.getString( 2)+" "+ cursor.getString( 3 )+" "+cursor.getString( 4)+" "+cursor.getString( 5 )+cursor.getString( 6 ));
                cursor.moveToNext();
            }
        }
        cursor = hpd.GetData();
        Log.v("what","Data for second");
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast())
            {
                Log.v("what",cursor.getString(0));
                cursor.moveToNext();
            }
        }
        cursor=APT.GetData();
        Log.v("what","Date for third");
        cursor.moveToFirst();
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast())
            {
                Log.v("what",cursor.getString(0)+cursor.getInt(1) + " " +cursor.getInt(2));
                cursor.moveToNext();
            }
        }
    }
    public void Enterattendence( View view ) {
        Intent intent = new Intent( MainActivity.this, EnterAttendence.class);
        startActivity(intent);
    }
    public void EnterTimeTable( View view ) {
        Intent intent = new Intent( MainActivity.this, EnterSub.class );
        startActivity(intent);
    }
}
