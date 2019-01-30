package com.example.dhvanil.attendencecounter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import java.util.ArrayList;

public class tue extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public tue() {
    }
    public static mon newInstance( String param1, String param2 ) {
        mon fragment = new mon();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View v =inflater.inflate( R.layout.fragment_mon, container, false );
        final Spinner spinner1 = v.findViewById( R.id.Spinner1 );
        final Spinner spinner2 = v.findViewById( R.id.Spinner2 );
        final Spinner spinner3 = v.findViewById( R.id.Spinner3 );
        final Spinner spinner4 = v.findViewById( R.id.Spinner4 );
        final Spinner spinner5 = v.findViewById( R.id.Spinner5 );
        final Spinner spinner6 = v.findViewById( R.id.Spinner6 );
        ArrayList a= new ArrayList<String>(  );
        TinyDB tinyDB =new TinyDB( getContext());
        a=tinyDB.getListString( "A");
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,a);
        spinner1.setAdapter( adapter );
        spinner2.setAdapter( adapter );
        spinner3.setAdapter( adapter );
        spinner4.setAdapter( adapter );
        spinner5.setAdapter( adapter );
        spinner6.setAdapter( adapter );
        Button btn= v.findViewById( R.id.EnterIntoData );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                String a1 = spinner1.getSelectedItem().toString();
                String a2 = spinner2.getSelectedItem().toString();
                String a3 = spinner3.getSelectedItem().toString();
                String a4 = spinner4.getSelectedItem().toString();
                String a5 = spinner5.getSelectedItem().toString();
                String a6 = spinner6.getSelectedItem().toString();
                Log.v("TAG","aaaaaaaaa"+a1+a2+a3+a4+a5+a6);
                DataBaseHelper hp = new DataBaseHelper( getContext(),"MyName" );

                if(hp.insert(a1,a2,a3,a4,a5,a6)==true){
                    Toast.makeText( getContext(),"Yeah",Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    Toast.makeText( getContext(),"NOOOOOO!!!",Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        return v;
    }

}
