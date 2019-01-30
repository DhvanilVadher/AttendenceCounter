package com.example.dhvanil.attendencecounter;


import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.nio.Buffer;
import java.util.ArrayList;

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

    public void Show( View view ) {

        DataBaseHelper hp = new DataBaseHelper( EnterAttendence.this,"Name");
        Cursor cursor = hp.GetData();
        StringBuffer buffer = new StringBuffer(  );
        int count=0;
        while (cursor.moveToNext())
        {
            buffer.append(cursor.getString(1)+cursor.getString( 2) +cursor.getString( 3 )+cursor.getString( 4 )+cursor.getString( 5 ));
            count++;
        }
            Log.v( "esd","abcdef"+buffer.toString()+count);
    }
}
