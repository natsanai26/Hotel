package com.example.natsanai.hotel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Booking;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natsanai on 5/20/2018.
 */

public class SearchFragment extends Fragment {
    private HotelAPI hotelAPI;
    private RecyclerView bookingRV;
    private EditText email;
    private ImageView searchButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);
        init(view);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().equals(""))
                {
                    getAllBookings(email.getText().toString());
                }
            }
        });
        return view;
    }
    public void getAllBookings(String email)
    {
        Call<ResponseBody> responseBody = hotelAPI.getBookingsByEmail(email);
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonString = response.body().string();
                    Toast.makeText(getContext(),jsonString,Toast.LENGTH_LONG).show();
                    Gson gson = new Gson();
                    Type listType = new TypeToken<ArrayList<Booking>>(){}.getType();
                    ArrayList<Booking> bookings = gson.fromJson(jsonString,listType);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    public void init(View view)
    {
        hotelAPI = MyAPI.getHotelAPI();
        bookingRV = view.findViewById(R.id.booking_rv);
        email = view.findViewById(R.id.email);
        searchButton = view.findViewById(R.id.search);
    }
}
