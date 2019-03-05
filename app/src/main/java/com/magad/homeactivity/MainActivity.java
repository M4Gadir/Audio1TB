package com.magad.homeactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fm = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.hijaiyah:
                    fm.beginTransaction().add(R.id.wadah, new HijaiyahFragment()).addToBackStack("").commit();
                    return true;
                case R.id.hewan:
                    fm.beginTransaction().replace(R.id.wadah, new HewanActivity()).detach(new HijaiyahFragment()).addToBackStack("").commit();
                    return true;
                case R.id.entahlah:
                    fm.beginTransaction().replace(R.id.wadah, new EntahActivity()).detach(new HijaiyahFragment()).addToBackStack("").commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.wadah, new HijaiyahFragment()).addToBackStack("").commit();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
