package com.example.natsanai.hotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.natsanai.hotel.Activity.RoomBookingActivity;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Room;

import java.util.ArrayList;

/**
 * Created by natsanai on 5/20/2018.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Room> rooms;

    public RoomAdapter(Context context, ArrayList<Room> rooms)
    {
        this.context = context;
        this.rooms = rooms;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_rv_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Room room = rooms.get(position);
        holder.place.setText(room.getPlace());
        holder.price.setText(String.valueOf(room.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RoomBookingActivity.class);
                intent.putExtra("roomId",room.getRoomId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView place;
        public TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.place);
            price = itemView.findViewById(R.id.price);
        }
    }
}
