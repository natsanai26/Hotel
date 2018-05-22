package com.example.natsanai.hotel.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.natsanai.hotel.Interface.CarRentAPI;
import com.example.natsanai.hotel.MyAPI;
import com.example.natsanai.hotel.R;
import com.example.natsanai.hotel.model.CarRentResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarRentDetailActivity extends AppCompatActivity {

    private TextView location;
    private TextView brand;
    private TextView model;
    private TextView numberplate;
    private TextView vehicleYear;
    private TextView seat;
    private TextView price;
    private TextView vehicledetailsButton;
    private LinearLayout vehicledetails;
    private TextView transmission;
    private TextView cruisecontrol;
    private TextView cddvd;
    private TextView bluetooth;
    private TextView rearcamera;
    private TextView engine;

    private Button okButton;
    private Button cancelButton;

    private int vehicleId;

    private CarRentAPI carRentAPI;

    private ImageButton dateOutButton;
    private ImageButton dateReturnButton;
    private TextView dateOut;
    private TextView dateReturn;

    private EditText number;
    private EditText passportNumber;
    private EditText firstName;
    private EditText lastName;
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


            dateOut.setText(date);
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

            dateReturn.setText(date);

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent_detail);
        init();
        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("carRent");
        Gson gson = new Gson();
        CarRentResponse.CarRent carRent = gson.fromJson(jsonString, CarRentResponse.CarRent.class);
        vehicleId = carRent.getVehicleId();
        setupView(carRent);
        Log.d("car_rents",jsonString);

        dateOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CarRentDetailActivity.this ,
                        android.R.style.Theme_Black_NoTitleBar,mDateSetListener1,Year,Month,Day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CarRentDetailActivity.this ,
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
                Date dateOut1 = dateFormat.parse(dateOut.getText().toString());
                Date dateReturn1 = dateFormat.parse(dateReturn.getText().toString());
                long dateOut1Long = dateOut1.getTime();
                long dateReturn1Long = dateReturn1.getTime();
                String json = String.format("{\n" +
                        "        \"customer\": {\n" +
                        "            \"number\": \"%s\",\n" +
                        "            \"passportNumber\": \"%s\",\n" +
                        "            \"customerFname\": \"%s\",\n" +
                        "            \"customerLname\": \"%s\"\n" +
                        "        },\n" +
                        "        \"vehicle\": {\n" +
                        "            \"vehicleId\": %d\n" +
                        "        },\n" +
                        "        \"dateOut\": %d,\n" +
                        "        \"dateReturn\": %d,\n" +
                        "        \"code\" : {\n" +
                        "          \"codeName\" : \"%s\"\n" +
                        "          \n" +
                        "        }\n" +
                        "}",
                        number.getText().toString(),
                        passportNumber.getText().toString(),
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        vehicleId,
                        dateOut1Long,
                        dateReturn1Long,
                        ""
                        );
                    createRental(json);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void createRental(String jsonString)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonString);
        Call<ResponseBody> responseBody = carRentAPI.createRental("SOA1234",body);
        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String msg = response.body().string();
                    Toast.makeText(CarRentDetailActivity.this,msg,Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    public void setupView(CarRentResponse.CarRent carRent)
    {
        location.setText(carRent.getLocation());
        brand.setText(carRent.getBrand());
        model.setText(carRent.getModel());
        //numberplate.setText(carRent.getNumberplate());
        vehicleYear.setText(String.valueOf(carRent.getVehicleYear()));
        seat.setText(String.valueOf(carRent.getSeat()));
        price.setText(String.valueOf(carRent.getPrice()));

        List<CarRentResponse.CarRent.Vehicledetails> vehicledetails = carRent.getVehicledetails();
        CarRentResponse.CarRent.Vehicledetails vehicledetails1 = vehicledetails.get(0);
        transmission.setText(vehicledetails1.getTransmission());
        cruisecontrol.setText(vehicledetails1.getCruisecontrol());
        cddvd.setText(vehicledetails1.getCddvd());
        bluetooth.setText(vehicledetails1.getBluetooth());
        rearcamera.setText(vehicledetails1.getRearcamera());
        engine.setText(vehicledetails1.getEngine());

       this.vehicledetails.setVisibility(View.GONE);
        this.vehicledetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CarRentDetailActivity.this.vehicledetails.getVisibility()==View.GONE)
                {
                    CarRentDetailActivity.this.vehicledetails.setVisibility(View.VISIBLE);
                }
                else
                {
                    CarRentDetailActivity.this.vehicledetails.setVisibility(View.GONE);
                }
            }
        });

    }
    public void init()
    {
        location = (TextView) findViewById(R.id.location);
        brand = (TextView) findViewById(R.id.brand);
        model = (TextView) findViewById(R.id.model);
        numberplate = (TextView) findViewById(R.id.numPassenger);
        vehicleYear = (TextView) findViewById(R.id.vehicleYear);
        seat = (TextView) findViewById(R.id.seat);
        price = (TextView) findViewById(R.id.price);
        vehicledetailsButton = (TextView) findViewById(R.id.vehicledetailsButton);


        vehicledetails = (LinearLayout) findViewById(R.id.vehicledetails);


        transmission = (TextView) findViewById(R.id.transmission);
        cruisecontrol = (TextView) findViewById(R.id.cruisecontrol);
        cddvd = (TextView) findViewById(R.id.cddvd);
        bluetooth = (TextView) findViewById(R.id.bluetooth);
        rearcamera = (TextView) findViewById(R.id.rearcamera);
        engine = (TextView) findViewById(R.id.engine);

        okButton = (Button) findViewById(R.id.okButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        carRentAPI = MyAPI.getCarRentAPI();

        dateOutButton = (ImageButton) findViewById(R.id.dateOutButton);
        dateReturnButton = (ImageButton) findViewById(R.id.dateReturnButton);

        dateOut = (TextView) findViewById(R.id.dateOut) ;
        dateReturn = (TextView) findViewById(R.id.dateReturn);

        number = (EditText) findViewById(R.id.Number);
        passportNumber = (EditText) findViewById(R.id.passportNumber);
        firstName = (EditText) findViewById(R.id.FirstName);
        lastName = (EditText) findViewById(R.id.LastName);
    }
}
