package com.example.natsanai.hotel.Activity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.natsanai.hotel.Interface.TourAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarTypeResponse;
import com.example.natsanai.hotel.model.RateResponse;
import com.example.natsanai.hotel.model.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by natsanai on 5/21/2018.
 */


public class CarBookingActivity extends AppCompatActivity {
    private TourAPI tourAPI;
    private Spinner destination;
    private Spinner carType;
    private EditText email;
    private EditText detail;
    private EditText payment;
    private EditText numCar;
    private EditText numPassenger;
    private EditText place;
    private TextView departureDate;
    private ImageButton departureDateButton;
    private Button okButton;
    private int rateId;
    private int carTypeId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_booking_fragment);
        init();

        setupDestinationSpinner();
        setupCarTypeSpinner();

        departureDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CarBookingActivity.this ,
                        android.R.style.Theme_Black_NoTitleBar,mDateSetListener,Year,Month,Day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    Date departureDate2 = dateFormat.parse(departureDate.getText().toString());

                    long departureDate2Long = departureDate2.getTime();


                    String jsonString = String.format("{\n" +
                            "\t\t           \n" +
                            "            \"detail\": \"%s\",\n" +
                            "            \"payment\": \"%s\",\n" +
                            "            \"numCar\": %d,\n" +
                            "            \"numPassenger\": %d,\n" +
                            "            \"place\": \"%s\",\n" +
                            "            \"departureDate\": %d\n" +
                            "        }",
                                        detail.getText().toString(),
                                        payment.getText().toString(),
                                        Integer.parseInt(numCar.getText().toString()),
                                        Integer.parseInt(numPassenger.getText().toString()),
                                        place.getText().toString(),
                                        departureDate2Long);

                    //Toast.makeText(CarBookingActivity.this,jsonString,Toast.LENGTH_SHORT).show();
                    addCarBooking(jsonString);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void addCarBooking(String jsonString)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonString);
        Call<ResponseBody> responseBody = tourAPI.addCarBooking(email.getText().toString(),rateId,carTypeId,body);
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String msg = null;
                try {
                    msg = response.body().string();
                    Toast.makeText(CarBookingActivity.this,msg,Toast.LENGTH_SHORT).show();
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    public void setupDestinationSpinner()
    {
        Call<ResponseBody> responseBody = tourAPI.getAllRates();
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonString = response.body().string();
                    //Log.d("all_rates",jsonString);
                    Gson gson = new Gson();
                    RateResponse rateResponse = gson.fromJson(jsonString,RateResponse.class);
                    final List<RateResponse.Rate> rates = rateResponse.getResult();
                    final ArrayList<String> allRates = new ArrayList<String>();
                    for (RateResponse.Rate r:rates)
                    {
                        allRates.add(r.getDestination());
                    }
                    ArrayAdapter<String> destinationAdapter = new ArrayAdapter<String>(CarBookingActivity.this,android.R.layout.simple_spinner_item,allRates);
                    destination.setAdapter(destinationAdapter);

                    destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            rateId = rates.get(position).getIdRate();
                            Toast.makeText(CarBookingActivity.this,rateId+"",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
    public void setupCarTypeSpinner()
    {
        Call<ResponseBody> responseBody = tourAPI.getAllCarType();
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonString = response.body().string();
                    Gson gson = new Gson();
                    CarTypeResponse carTypeResponse = gson.fromJson(jsonString,CarTypeResponse.class);
                    final List<CarTypeResponse.CarType> carTypes = carTypeResponse.getResult();
                    ArrayList<String> allCarTypes = new ArrayList<String>();
                    for (CarTypeResponse.CarType c:carTypes)
                    {
                        allCarTypes.add(c.getName());
                    }
                    ArrayAdapter<String> carTypeAdapter = new ArrayAdapter<String>(CarBookingActivity.this,android.R.layout.simple_spinner_item,allCarTypes);
                    carType.setAdapter(carTypeAdapter);

                    carType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            carTypeId = carTypes.get(position).getIdCarType();
                            Toast.makeText(CarBookingActivity.this,carTypeId+"",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

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
        tourAPI = MyAPI.getTourAPI();
        destination = (Spinner) findViewById(R.id.destination);
        carType = (Spinner) findViewById(R.id.carType);
        email = (EditText) findViewById(R.id.email);
        detail = (EditText) findViewById(R.id.detail);
        payment = (EditText) findViewById(R.id.payment);
        numCar = (EditText) findViewById(R.id.numCar);
        numPassenger = (EditText) findViewById(R.id.numPassenger);
        place = (EditText) findViewById(R.id.place);
        departureDate = (TextView) findViewById(R.id.departureDate);
        departureDateButton = (ImageButton) findViewById(R.id.departureDateButton);
        okButton = (Button) findViewById(R.id.okButton);

    }
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
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

            departureDate.setText(date);

        }

    };
}
