package com.example.natsanai.hotel;

import com.example.natsanai.hotel.Interface.CarRentAPI;
import com.example.natsanai.hotel.Interface.HotelAPI;
import com.example.natsanai.hotel.Interface.TourAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by natsanai on 5/20/2018.
 */

public class MyAPI
{
    public static final String BASE_URL_HOTEL = "http://158.108.207.221:8080/hotel/";
    public static final String BASE_URL_TOUR = "http://158.108.207.221:8080/tour/rest/services/";
    public static final String BASE_URL_CAR_RENT = "http://158.108.207.221:8080/CARRENT/rest/services/";

    private static HotelAPI hotelAPI;
    private static TourAPI tourAPI;
    private static CarRentAPI carRentAPI;

    public static HotelAPI getHotelAPI()
    {
        if (hotelAPI==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_HOTEL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            hotelAPI = retrofit.create(HotelAPI.class);
        }
        return hotelAPI;
    }
    public static TourAPI getTourAPI()
    {
        if (tourAPI==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_TOUR)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            tourAPI = retrofit.create(TourAPI.class);
        }
        return tourAPI;
    }
    public static CarRentAPI getCarRentAPI()
    {
        if (carRentAPI==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_CAR_RENT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            carRentAPI = retrofit.create(CarRentAPI.class);
        }
        return carRentAPI;
    }
}
