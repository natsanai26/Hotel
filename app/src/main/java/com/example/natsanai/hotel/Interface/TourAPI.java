package com.example.natsanai.hotel.Interface;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by natsanai on 5/21/2018.
 */

public interface TourAPI {
    @POST("booking/create")
    Call<ResponseBody> addCarBooking(
            @Query("email") String email,
            @Query("rateId") int rateId,
            @Query("carTypeId") int carTypeId,
            @Body RequestBody body
            );

    @GET("rates")
    Call<ResponseBody> getAllRates(

    );

    @GET("cars/types")
    Call<ResponseBody> getAllCarType(

    );
    @GET("rates/search")
    Call<ResponseBody> getRatesByDestination(
            @Query("destination") String destination
    );

    @GET("booking/search")
    Call<ResponseBody> getCarBookingsByEmail(
            @Query("email") String email
    );
}
