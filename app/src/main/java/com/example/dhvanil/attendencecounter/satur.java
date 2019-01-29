package com.example.dhvanil.attendencecounter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class satur extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public satur() {
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
        Spinner spinner1 = v.findViewById( R.id.Spinner1 );
        Spinner spinner2 = v.findViewById( R.id.Spinner2 );
        Spinner spinner3 = v.findViewById( R.id.Spinner3 );
        Spinner spinner4 = v.findViewById( R.id.Spinner4 );
        Spinner spinner5 = v.findViewById( R.id.Spinner5 );
        Spinner spinner6 = v.findViewById( R.id.Spinner6 );
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
        return v;
    }

}
