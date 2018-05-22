package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Booking;
import com.example.natsanai.hotel.model.Room;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        /*for (Booking rb:roomBookings)
        {
            Call<ResponseBody> responseBody = hotelAPI.getRoomById(rb.getRoomId());
            responseBody.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String json = response.body().string();
                        Gson gson = new Gson();
                        Room r = gson.fromJson(json,Room.class);
                        //RoomBookingAdapter.this.rooms.add(r);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }*/
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_booking_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Booking b = roomBookings.get(position);

        holder.email.setText(b.getEmail());

        Date d1 = new Date(b.getDateCheckIn());
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String d11 = df.format(d1);
        holder.dateCheckIn.setText(d11);

        Date d2 = new Date(b.getDateCheckIn());
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        String d21 = df.format(d2);
        holder.dateCheckOut.setText(d21);

        //String des = rooms.get(position).getPlace();
        //holder.destination.setText(des);
    }

    @Override
    public int getItemCount() {
        return roomBookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView destination;
        public TextView email;
        public TextView dateCheckIn;
        public TextView dateCheckOut;
        public ViewHolder(View itemView) {
            super(itemView);
            destination = itemView.findViewById(R.id.destination);
            email = itemView.findViewById(R.id.email);
            dateCheckIn = itemView.findViewById(R.id.dateCheckIn);
            dateCheckOut = itemView.findViewById(R.id.dateCheckOut);
        }
    }

}
