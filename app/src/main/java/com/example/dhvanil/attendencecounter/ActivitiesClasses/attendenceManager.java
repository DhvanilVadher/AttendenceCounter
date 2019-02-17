package com.example.dhvanil.attendencecounter.ActivitiesClasses;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dhvanil.attendencecounter.R;
import com.example.dhvanil.attendencecounter.adaptersClasses.List;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.dhvanil.attendencecounter.adaptersClasses.ApplicationClass.hp;

public class attendenceManager extends AppCompatActivity {

    ListView listView ;
    String Date,Day;
    ArrayList<String>Lectures= new ArrayList<>();
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_attendence_manager );
        listView = findViewById( R.id.ListView);
        Intent intent = getIntent();
        Date = intent.getStringExtra("date");
        Day = intent.getStringExtra("Day");
        getLecturesList();
        CustomAdapter adapter = new CustomAdapter(Lectures,this);
        listView.setAdapter(adapter);
    }

    private void getLecturesList() {
        HashMap<String,Integer>hashMap = new HashMap<>();
        hashMap.put("MONDAY",1);
        hashMap.put("TUESDAY",2);
        hashMap.put("WEDNESDAY",3);
        hashMap.put("THURSDAY",4);
        hashMap.put("FRIDAY",5);
        hashMap.put("SATURDAY",6);
        if(Day!=null)
        {
            Cursor cursor = hp.select(hashMap.get(Day));
            if(cursor.moveToFirst()){
            while (!cursor.isAfterLast())
            {
                for(int i=0;i<=5;i++)
                {
                    String a=cursor.getString(i);
                    Lectures.add(a);
                }
               cursor.moveToNext();
             }
            }
        }
        else{
            Log.v("adas","noooooo why");
        }
    }

    class CustomAdapter extends BaseAdapter{
            ArrayList<String> arrayList;
            Context context;

        public CustomAdapter( ArrayList<String> arrayList, Context context ) {
            this.arrayList = arrayList;
            this.context = context;
        }

        public ArrayList<String> getArrayList() {
            return arrayList;
        }

        public void setArrayList( ArrayList<String> arrayList ) {
            this.arrayList = arrayList;
        }

        public Context getContext() {
            return context;
        }

        public void setContext( Context context ) {
            this.context = context;
        }

        @Override
            public int getCount() {
                return arrayList.size();
            }
            @Override
            public Object getItem( int position ) {
                return null;
            }
            @Override
            public long getItemId( int position ) {
                return 0;
            }
            @Override
            public View getView( final int position, View convertView, ViewGroup parent ) {
                convertView = getLayoutInflater().inflate(R.layout.dateattendencesample,null );
                TextView textView = convertView.findViewById( R.id.subname);
                RadioButton attended = convertView.findViewById( R.id.present);
                RadioButton abscent = convertView.findViewById( R.id.abscent);
                RadioButton Holiday = convertView.findViewById( R.id.Holiday);
                textView.setText(arrayList.get(position));
                //                ImageButton imageButton = convertView.findViewById( R.id.imagedelete );
//                TextView textView  = convertView.findViewById( R.id.Subjecttext );
//                textView.setText( arrayList.get( position ));
                return convertView;
            }
        }
}
