package com.example.natsanai.hotel.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.natsanai.hotel.Fragment.HomeFragment;
import com.example.natsanai.hotel.Fragment.SearchFragment;
import com.example.natsanai.hotel.R;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            actionBar = getSupportActionBar();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    actionBar.setTitle("Home");
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new HomeFragment()).commit();
                    return true;
                case R.id.navigation_Search:
                    actionBar.setTitle("Search");
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,new SearchFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null)
        {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Home");
            getSupportFragmentManager().beginTransaction().add(R.id.content,new HomeFragment()).commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
