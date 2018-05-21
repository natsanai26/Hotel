package com.example.natsanai.hotel.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.Room;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomBookingActivity extends AppCompatActivity {

    private HotelAPI hotelAPI;
    private TextView roomIdView;
    private TextView dateCheckIn;
    private TextView dateCheckOut;
    private ImageButton dateCheckInButton;
    private ImageButton dateCheckOutButton;
    private EditText email;
    private Button okButton;
    private int roomId;
    private DatePickerDialog.OnDateSetListener mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            String date = null;
            month = month + 1;
            if(month <10){
                if(day < 10){
                    date = "0" + day + "-0" + month + "-" + year ;
                }
                else {
                    date = day + "-0" + month + "-" +year;
                }
            }
            else {
                if(day<10) {
                    date = "0" + day + "-" + month + "-" + year;
                }
                else {
                    date = day + "-" + month + "-" + year;
                }

            }

            dateCheckIn.setText(date);

        }

    };
    private DatePickerDialog.OnDateSetListener mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            String date = null;
            month = month + 1;
            if(month <10){
                if(day < 10){
                    date = "0" + day + "-0" + month + "-" + year ;
                }
                else {
                    date = day + "-0" + month + "-" +year;
                }
            }
            else {
                if(day<10) {
                    date = "0" + day + "-" + month + "-" + year;
                }
                else {
                    date = day + "-" + month + "-" + year;
                }

            }

            dateCheckOut.setText(date);

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_booking);
        init();
        Intent intent = getIntent();
        roomId = intent.getIntExtra("roomId",-1);
        roomIdView.setText(String.valueOf(roomId));
        Toast.makeText(this,"roomId:"+roomId,Toast.LENGTH_LONG).show();

        dateCheckInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(RoomBookingActivity.this ,
                        android.R.style.Theme_Black_NoTitleBar,mDateSetListener1,Year,Month,Day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateCheckOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(RoomBookingActivity.this ,
                        android.R.style.Theme_Black_NoTitleBar,mDateSetListener2,Year,Month,Day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date checkInDate = dateFormat.parse(dateCheckIn.getText().toString());
                    Date checkOutDate = dateFormat.parse(dateCheckOut.getText().toString());
                    long checkInDateLong = checkInDate.getTime();
                    long checkOutDateLong = checkOutDate.getTime();

                    String jsonString = String.format("{\n" +
                                    "\"dateCheckIn\": %d,\n" +
                                    "\"dateCheckOut\": %d,\n" +
                                    "\"email\": \"%s\",\n" +
                                    "\"name\": \"%s\",\n" +
                                    "\"number\": \"%s\",\n" +
                                    "\"roomId\": %d\n" +
                                    "}",

                            checkInDateLong,
                            checkOutDateLong,
                            email.getText().toString(),
                            "nat",
                            "0985746480",
                            roomId

                            );
                    Toast.makeText(RoomBookingActivity.this,jsonString,Toast.LENGTH_SHORT).show();
                    addBooking(jsonString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void addBooking(String jsonString)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonString);
        Call<ResponseBody> responseBody = hotelAPI.addBooking(body);
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String msg = response.body().string();
                    Toast.makeText(RoomBookingActivity.this,msg,Toast.LENGTH_SHORT).show();
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
        hotelAPI = MyAPI.getHotelAPI();
        roomIdView = (TextView) findViewById(R.id.roomId);
        dateCheckIn = (TextView) findViewById(R.id.dateCheckIn) ;
        dateCheckOut = (TextView) findViewById(R.id.dateCheckOut);
        dateCheckInButton = (ImageButton) findViewById(R.id.dateCheckInButton);
        dateCheckOutButton = (ImageButton) findViewById(R.id.dateCheckOutButton);
        okButton = (Button) findViewById(R.id.okButton);
        email = (EditText) findViewById(R.id.email);

    }
}
