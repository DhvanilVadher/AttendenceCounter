package com.example.dhvanil.attendencecounter.ActivitiesClasses;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.dhvanil.attendencecounter.adaptersClasses.DataClass;
import com.example.dhvanil.attendencecounter.Adapters.DateAdapter;
import com.example.dhvanil.attendencecounter.R;
import com.example.dhvanil.attendencecounter.DataBaseClass.TinyDB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.Startdate;
import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.Todaydate;

public class EnterAttendence extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    public String starting ,ending;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_enter_attendence);
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
        Todaydate=LocalDate.now();
        Todaydate.plusDays(1);
        for(LocalDate date = Startdate;date.isBefore(Todaydate.plusDays(1));date= date.plusDays( 1 )){
            String a= date.format(formatter);
            String b= String.valueOf(date.getDayOfWeek());
            DataClass dataClass = new DataClass(a,b);
            dataClasses.add(dataClass);
        }
        DateAdapter dateAdapter = new DateAdapter(this,dataClasses);
        recyclerView.setAdapter( dateAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.menu_main,menu );
        return true;
    }

}
