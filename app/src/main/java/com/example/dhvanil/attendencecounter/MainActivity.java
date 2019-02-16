package com.example.dhvanil.attendencecounter;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static com.example.dhvanil.attendencecounter.ApplicationClass.Startdate;
import static com.example.dhvanil.attendencecounter.ApplicationClass.Todaydate;
import static com.example.dhvanil.attendencecounter.ApplicationClass.hp;
public class MainActivity extends AppCompatActivity {
    public String startingDate,todaysDate;
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        startingDate= tinyDB.getString( "StartingDate");
    }
    public void about( View view ) {
    }
    public void showAttendence( View view ) {

    }
    public void Enterattendence( View view ) {
        Intent intent = new Intent( MainActivity.this,EnterAttendence.class);
        startActivity(intent);
    }
    public void EnterTimeTable( View view ) {
        Intent intent = new Intent( MainActivity.this,EnterSub.class );
        startActivity(intent);
    }
}
