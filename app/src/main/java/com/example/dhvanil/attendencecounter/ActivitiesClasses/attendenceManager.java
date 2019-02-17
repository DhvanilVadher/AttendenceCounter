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
    ArrayList<List>Lectures1= new ArrayList<>(  );
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_attendence_manager );
        listView = findViewById( R.id.ListView);
        Intent intent = getIntent();
        Date = intent.getStringExtra("date");
        Day = intent.getStringExtra("Day");
        getLecturesList();
        CustomAdapter adapter = new CustomAdapter(Lectures1,this);
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
                    if(!a.equals("--------none-------"))
                    {
                        List list = new List( a,true,false,false);
                        Lectures1.add( list );
                    }
                }
               cursor.moveToNext();
               }
            }
        }
        else{
            Log.v("adas","noooooo why");
        }
    }

    public void EnterIntoData(View view)
    {
        for(int i=0;i<Lectures1.size();i++){
        }
    }
    class CustomAdapter extends BaseAdapter{
            ArrayList<List> arrayList;
            Context context;
        public CustomAdapter( ArrayList<List> arrayList, Context context ) {
            this.arrayList = arrayList;
            this.context = context;
        }
        public ArrayList<List> getArrayList() {
            return arrayList;
        }
        public void setArrayList( ArrayList<List> arrayList ) {
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
                final RadioButton attended = convertView.findViewById( R.id.present);
                final RadioButton abscent = convertView.findViewById( R.id.abscent);
                final RadioButton Holiday = convertView.findViewById( R.id.Holiday);
                textView.setText(arrayList.get(position).getDay());
                attended.setChecked(arrayList.get(position).isAttended());
                abscent.setChecked(arrayList.get(position).isAttended());
                Holiday.setChecked( arrayList.get(position).isAttended());
                attended.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        arrayList.get(position).setAttended(true);
                        arrayList.get(position).setAbsecent(false);
                        arrayList.get(position).setHoliday(false);
                        abscent.setChecked(false);
                        Holiday.setChecked(false);
                    }
                } );
                abscent.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        arrayList.get(position).setAttended(false);
                        arrayList.get(position).setAbsecent(true);
                        arrayList.get(position).setHoliday(false);
                        attended.setChecked(false);
                        Holiday.setChecked(false);
                    }
                } );
                Holiday.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        arrayList.get(position).setAttended(false);
                        arrayList.get(position).setAbsecent(false);
                        arrayList.get(position).setHoliday(true);
                        abscent.setChecked(false);
                        attended.setChecked(false);
                    }
                } );
//                                ImageButton imageButton = convertView.findViewById( R.id.imagedelete );
//                TextView textView  = convertView.findViewById( R.id.Subjecttext );
//                textView.setText( arrayList.get( position ));
                return convertView;
            }
        }
}
