package com.example.natsanai.hotel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natsanai.hotel.R;

/**
 * Created by natsanai on 5/20/2018.
 */

public class HomeFragment extends Fragment {

    private TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition())
            {
                case 0:
                    getFragmentManager().beginTransaction().replace(R.id.home_content,new RoomFragment()).commit();
                    break;
                case 1:
                    getFragmentManager().beginTransaction().replace(R.id.home_content,new CarFragment()).commit();
                    break;
                case 2:
                    getFragmentManager().beginTransaction().replace(R.id.home_content,new RoomAndCarFragment()).commit();
                    break;

            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        if (savedInstanceState==null)
        {
            getFragmentManager().beginTransaction().add(R.id.home_content,new RoomFragment()).commit();
        }
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
        return view;
    }
}
