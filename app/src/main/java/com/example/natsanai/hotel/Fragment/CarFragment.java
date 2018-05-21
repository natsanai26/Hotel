package com.example.natsanai.hotel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natsanai.hotel.R;

/**
 * Created by natsanai on 5/20/2018.
 */

public class CarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment,container,false);
        getFragmentManager().beginTransaction().add(R.id.car_content,new SelectCarPageFragment()).commit();
        return view;
    }
}
