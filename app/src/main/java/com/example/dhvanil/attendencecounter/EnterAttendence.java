package com.example.dhvanil.attendencecounter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class EnterAttendence extends AppCompatActivity {


    Toolbar toolbar;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_enter_attendence);
        toolbar = findViewById( R.id.toolbar1 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Enter Subjects" );
       // toolbar.setTitle();
        toolbar.setTitleTextColor( Color.parseColor("#FF0017E4"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp );

    }
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.menu_main,menu );
        return true;
    }

    public void SubmitData( View view ) {
    }
}
