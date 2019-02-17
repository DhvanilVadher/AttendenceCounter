package com.example.dhvanil.attendencecounter.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment> fregment1=new ArrayList<>();
    public ArrayList<String>titles = new ArrayList<>();

    public MyAdapter( FragmentManager fm ) {
        super( fm );
    }

    @Override
    public Fragment getItem( int i ) {
        return fregment1.get(i);
    }

    @Override
    public int getCount() {
        return fregment1.size();
    }

    public void addFregment(Fragment fragment,String a){
        fregment1.add( fragment );
        titles.add(a);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle( int position ) {
        return titles.get(position);
    }
}
