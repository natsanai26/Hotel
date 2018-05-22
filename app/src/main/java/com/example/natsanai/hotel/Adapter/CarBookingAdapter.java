package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarBookingResponse;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarBookingAdapter extends RecyclerView.Adapter<CarBookingAdapter.ViewHolder> {
    private Context context;
    private List<CarBookingResponse.Booking> carBookings;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_booking_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return carBookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
