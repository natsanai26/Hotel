package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarBookingResponse;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarBookingAdapter extends RecyclerView.Adapter<CarBookingAdapter.ViewHolder> {
    private Context context;
    private List<CarBookingResponse.Booking> carBookings;

    public CarBookingAdapter(Context context,List<CarBookingResponse.Booking> carBookings)
    {
        this.context = context;
        this.carBookings = carBookings;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_booking_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CarBookingResponse.Booking cb = carBookings.get(position);

        holder.destination.setText(cb.getRate().getDestination());
        holder.carType.setText(cb.getCarType().getName());
        holder.email.setText(cb.getMember().getEmail());
        holder.departureDate.setText(cb.getDepartureDate());
    }

    @Override
    public int getItemCount() {
        return carBookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView destination;
        public TextView carType;
        public TextView email;
        public TextView departureDate;
        public ViewHolder(View itemView) {
            super(itemView);
            destination = itemView.findViewById(R.id.destination);
            carType = itemView.findViewById(R.id.carType);
            email = itemView.findViewById(R.id.email);
            departureDate = itemView.findViewById(R.id.departureDate);
        }
    }
}
