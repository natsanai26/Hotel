package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Booking;
import com.example.natsanai.hotel.model.Room;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natsanai on 5/22/2018.
 */

public class RoomBookingAdapter extends RecyclerView.Adapter<RoomBookingAdapter.ViewHolder> {

    private Context context;
    private List<Booking> roomBookings;
    private ArrayList<Room> rooms;
    private HotelAPI hotelAPI;

    public RoomBookingAdapter(Context context,List<Booking> roomBookings)
    {
        this.context = context;
        this.roomBookings = roomBookings;
        hotelAPI = MyAPI.getHotelAPI();
        for (Booking rb:roomBookings)
        {
            Call<ResponseBody> responseBody = hotelAPI.getRoomById(rb.getRoomId());
            responseBody.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String json = response.body().string();
                        Gson gson = new Gson();
                        Room r = gson.fromJson(json,Room.class);
                        RoomBookingAdapter.this.rooms.add(r);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_booking_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return roomBookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
