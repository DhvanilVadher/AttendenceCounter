package com.example.dhvanil.attendencecounter;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;


public class EnterDays extends AppCompatActivity {

    ArrayList<String> a ;
    private String m_Text = "";
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_enter_days );

        final ViewPager pager = (ViewPager)findViewById(R.id.ViewPager);
        MyAdapter adapter1 = new MyAdapter( getSupportFragmentManager());
        adapter1.addFregment(new mon(),"MON");
        adapter1.addFregment(new tue(),"TUE");
        adapter1.addFregment(new wed(),"WED");
        adapter1.addFregment(new thurs(),"THU");
        adapter1.addFregment(new fri(),"FRI");
        adapter1.addFregment(new satur(),"SAT");
        pager.setAdapter(adapter1 );
        final TabLayout tabLayout = findViewById( R.id.tablayout );
        tabLayout.addTab(tabLayout.newTab().setText("MONDAY"));
        tabLayout.addTab(tabLayout.newTab().setText("TUESDAY"));
        tabLayout.addTab(tabLayout.newTab().setText("WEDNESDAY"));
        tabLayout.addTab(tabLayout.newTab().setText("THURSDAY"));
        tabLayout.addTab(tabLayout.newTab().setText("FRIDAY"));
        tabLayout.addTab(tabLayout.newTab().setText("SATURDAY"));
        tabLayout.setupWithViewPager(pager);

      }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {   getMenuInflater().inflate( R.menu.menu_main,menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
