package com.example.dhvanil.attendencecounter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
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

    public void SubmitData( View view ) {
    }
}
