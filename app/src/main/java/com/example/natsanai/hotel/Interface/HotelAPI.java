package com.example.natsanai.hotel.Interface;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

/**
 * Created by natsanai on 5/20/2018.
 */

public interface HotelAPI {

    @GET("rooms")
    Call<ResponseBody> getAllRooms();

    @GET("bookings/email/{email}")
    Call<ResponseBody> getBookingsByEmail(
            @Path("email") String email
    );

    @POST("bookings/create")
    Call<ResponseBody> addBooking(
      @Body RequestBody body
    );

}
