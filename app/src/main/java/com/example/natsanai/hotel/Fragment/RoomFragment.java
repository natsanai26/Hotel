package com.example.natsanai.hotel.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.example.natsanai.hotel.Adapter.RoomAdapter;
import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natsanai on 5/20/2018.
 */

public class RoomFragment extends Fragment {
    private HotelAPI hotelAPI;
    private RecyclerView roomRV;
    private RoomAdapter roomAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.room_fragment,container,false);
        init(view);

        getAllRooms();

        return view;
    }
    public void getAllRooms()
    {
        Call<ResponseBody> responseBody = hotelAPI.getAllRooms();
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonString = response.body().string();
                    //Toast.makeText(getContext(),jsonString,Toast.LENGTH_LONG).show();
                    Type listType = new TypeToken<ArrayList<Room>>(){}.getType();
                    Gson gson = new Gson();
                    ArrayList<Room> rooms = gson.fromJson(jsonString,listType);

                    roomAdapter = new RoomAdapter(getContext(),rooms);
                    roomRV.setLayoutManager(new LinearLayoutManager(getContext()));
                    roomRV.setAdapter(roomAdapter);
                    roomRV.setHasFixedSize(true);

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

        roomRV = view.findViewById(R.id.room_rv);
    }
}
