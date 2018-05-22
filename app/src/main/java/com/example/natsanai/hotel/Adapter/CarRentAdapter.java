package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.natsanai.hotel.Activity.CarRentDetailActivity;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarRentResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarRentAdapter extends RecyclerView.Adapter<CarRentAdapter.ViewHolder>
{
    private Context context;
    private List<CarRentResponse.CarRent> carRents;
    public CarRentAdapter(Context context,List<CarRentResponse.CarRent> carRents)
    {
        this.context = context;
        this.carRents = carRents;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_rent_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CarRentResponse.CarRent carRent = carRents.get(position);

        holder.brand.setText(carRent.getBrand());
        holder.model.setText(carRent.getModel());
        holder.price.setText(String.valueOf(carRent.getPrice()));
        holder.location.setText(carRent.getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CarRentDetailActivity.class);
                Gson gson = new Gson();
                String jsonString = gson.toJson(carRent, CarRentResponse.CarRent.class);
                intent.putExtra("carRent",jsonString);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return carRents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView brand;
        public TextView model;
        public TextView price;
        public TextView location;
        public ImageView carRentPic;
        public ViewHolder(View itemView) {
            super(itemView);
            brand = itemView.findViewById(R.id.brand);
            model = itemView.findViewById(R.id.model);
            price = itemView.findViewById(R.id.price);
            location = itemView.findViewById(R.id.location);
            carRentPic = itemView.findViewById(R.id.carRentPic);
        }
    }
}
