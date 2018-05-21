package com.example.natsanai.hotel.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.natsanai.hotel.Activity.CarBookingActivity;
import com.example.natsanai.hotel.Activity.CarRentActivity;
import com.example.natsanai.hotel.R;

/**
 * Created by natsanai on 5/20/2018.
 */

public class CarFragment extends Fragment {
    private ImageView carBooking;
    private ImageView carRent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment,container,false);
        init(view);
        carBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CarBookingActivity.class);
                startActivity(intent);
            }
        });
        carRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CarRentActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void init(View view)
    {
        carBooking = view.findViewById(R.id.carBooking);
        carRent = view.findViewById(R.id.carRent);
    }
}
