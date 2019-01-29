package com.example.dhvanil.attendencecounter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EnterSub extends AppCompatActivity {
    ArrayList<String> a;
    private String m_Text = "";
    Toolbar toolbar;
    CustomAdapter adapter = new CustomAdapter();
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_enter_sub );
        toolbar = findViewById( R.id.toolbar );
        a=new ArrayList<>(  );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Enter Subjects" );
        toolbar.setTitleTextColor( Color.parseColor("#FF0017E4"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp );
        toolbar.setOnMenuItemClickListener( new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick( MenuItem menuItem ) {
                if(menuItem.getTitle().equals( "Add Subject" )){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EnterSub.this);
                    builder.setTitle("Title");
                    // Set up the input
                    final EditText input = new EditText(EnterSub.this);
                    // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

// Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick( DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                            a.add(m_Text);
                            Log.v("Tag","my name"+ a.size());
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
                return  true;
            }
        } );
        final ListView listView  =findViewById( R.id.list );
        listView.setAdapter(adapter);
    }  @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate( R.menu.menu_main,menu);
        return true;
    }

    @Override
    protected void onPause() {
        TinyDB tinyDB = new TinyDB( this );
        tinyDB.putListString( "A", a );

        super.onPause();
    }

    public void gotoEnterdays( View view ) {
        Intent intent = new Intent( EnterSub.this,EnterDays.class );
        startActivity( intent );
        finish();
    }

    public void SubmitData( View view ) {
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return a.size();
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
            convertView = getLayoutInflater().inflate( R.layout.samplelayput,null );
            ImageButton imageButton = convertView.findViewById( R.id.imagedelete );
            TextView textView  = convertView.findViewById( R.id.Subjecttext );
            textView.setText( a.get( position ));
            imageButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick( View v ) {
                    try {
                        a.remove( position );
                        updateview();
                    }catch (Exception e){
                        updateview();
                    }
                }
            } );
            return convertView;
        }
    }

    private void updateview() {
        CustomAdapter adapter1 = new CustomAdapter();
        ListView listView = findViewById( R.id.list );
        listView.setAdapter(adapter1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
