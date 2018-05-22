package com.example.natsanai.hotel.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarRentResponse;
import com.google.gson.Gson;

import java.util.List;

public class CarRentDetailActivity extends AppCompatActivity {

    private TextView location;
    private TextView brand;
    private TextView model;
    private TextView numberplate;
    private TextView vehicleYear;
    private TextView seat;
    private TextView price;
    private TextView vehicledetailsButton;
    private LinearLayout vehicledetails;
    private TextView transmission;
    private TextView cruisecontrol;
    private TextView cddvd;
    private TextView bluetooth;
    private TextView rearcamera;
    private TextView engine;

    private int vehicleId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent_detail);
        init();
        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("carRent");
        Gson gson = new Gson();
        CarRentResponse.CarRent carRent = gson.fromJson(jsonString, CarRentResponse.CarRent.class);
        vehicleId = carRent.getVehicleId();
        setupView(carRent);
        Log.d("car_rents",jsonString);
    }
    public void setupView(CarRentResponse.CarRent carRent)
    {
        location.setText(carRent.getLocation());
        brand.setText(carRent.getBrand());
        model.setText(carRent.getModel());
        //numberplate.setText(carRent.getNumberplate());
        vehicleYear.setText(String.valueOf(carRent.getVehicleYear()));
        seat.setText(String.valueOf(carRent.getSeat()));
        price.setText(String.valueOf(carRent.getPrice()));

        List<CarRentResponse.CarRent.Vehicledetails> vehicledetails = carRent.getVehicledetails();
        CarRentResponse.CarRent.Vehicledetails vehicledetails1 = vehicledetails.get(0);
        transmission.setText(vehicledetails1.getTransmission());
        cruisecontrol.setText(vehicledetails1.getCruisecontrol());
        cddvd.setText(vehicledetails1.getCddvd());
        bluetooth.setText(vehicledetails1.getBluetooth());
        rearcamera.setText(vehicledetails1.getRearcamera());
        engine.setText(vehicledetails1.getEngine());

       this.vehicledetails.setVisibility(View.GONE);
        this.vehicledetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CarRentDetailActivity.this.vehicledetails.getVisibility()==View.GONE)
                {
                    CarRentDetailActivity.this.vehicledetails.setVisibility(View.VISIBLE);
                }
                else
                {
                    CarRentDetailActivity.this.vehicledetails.setVisibility(View.GONE);
                }
            }
        });

    }
    public void init()
    {
        location = (TextView) findViewById(R.id.location);
        brand = (TextView) findViewById(R.id.brand);
        model = (TextView) findViewById(R.id.model);
        numberplate = (TextView) findViewById(R.id.numPassenger);
        vehicleYear = (TextView) findViewById(R.id.vehicleYear);
        seat = (TextView) findViewById(R.id.seat);
        price = (TextView) findViewById(R.id.price);
        vehicledetailsButton = (TextView) findViewById(R.id.vehicledetailsButton);


        vehicledetails = (LinearLayout) findViewById(R.id.vehicledetails);


        transmission = (TextView) findViewById(R.id.transmission);
        cruisecontrol = (TextView) findViewById(R.id.cruisecontrol);
        cddvd = (TextView) findViewById(R.id.cddvd);
        bluetooth = (TextView) findViewById(R.id.bluetooth);
        rearcamera = (TextView) findViewById(R.id.rearcamera);
        engine = (TextView) findViewById(R.id.engine);
    }
}
