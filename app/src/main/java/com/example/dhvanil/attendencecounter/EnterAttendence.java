package com.example.dhvanil.attendencecounter;


import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.example.dhvanil.attendencecounter.ApplicationClass.Startdate;
import static com.example.dhvanil.attendencecounter.ApplicationClass.Todaydate;
import static com.example.dhvanil.attendencecounter.ApplicationClass.hp;
import static com.example.dhvanil.attendencecounter.ApplicationClass.monfilled;

public class EnterAttendence extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    public String starting ,ending;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_attendence);
        recyclerView = findViewById( R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        putContent();
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle( "Enter Subjects" );
        toolbar.setTitleTextColor(Color.parseColor("#FF0017E4"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp );
    }
    private void putContent(){
        ArrayList<DataClass> dataClasses = new ArrayList<>(  );
        TinyDB tinyDB = new TinyDB( EnterAttendence.this );
        starting = tinyDB.getString( "StartingDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy");
        Startdate= LocalDate.parse(starting,formatter);
        Todaydate = LocalDate.now();
        for(LocalDate date = Startdate;date.isBefore(Todaydate);date= date.plusDays( 1 )){
            String a= date.format(formatter);
            String b= String.valueOf(date.getDayOfWeek());
            DataClass dataClass = new DataClass( a,b );
            dataClasses.add( dataClass );
        }
        DateAdapter dateAdapter = new DateAdapter( this,dataClasses);
        recyclerView.setAdapter( dateAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.menu_main,menu );
        return true;
    }

}
