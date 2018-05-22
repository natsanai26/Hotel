package com.example.natsanai.hotel.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.natsanai.hotel.Adapter.CarRentAdapter;
import com.example.natsanai.hotel.Interface.CarRentAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarRentResponse;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natsanai on 5/21/2018.
 */

public class CarRentActivity extends AppCompatActivity {
    private RecyclerView carRentRV;
    private CarRentAPI carRentAPI;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_rent_fragment);

        init();
        setupCarRentRV();

    }
    public void setupCarRentRV()
    {
        Call<ResponseBody> responseBody = carRentAPI.getAllCarRents();
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonString = response.body().string();
                    Log.d("all_car_rents",jsonString);
                    Gson gson = new Gson();
                    CarRentResponse carRentResponse = gson.fromJson(jsonString,CarRentResponse.class);

                     CarRentAdapter carRentAdapter = new CarRentAdapter(CarRentActivity.this,carRentResponse.getResult());
                carRentRV.setLayoutManager(new LinearLayoutManager(CarRentActivity.this));
                carRentRV.setAdapter(carRentAdapter);
                carRentRV.setHasFixedSize(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    public void init()
    {
        carRentAPI = MyAPI.getCarRentAPI();
        carRentRV = (RecyclerView) findViewById(R.id.car_rent_rv);
    }
}
