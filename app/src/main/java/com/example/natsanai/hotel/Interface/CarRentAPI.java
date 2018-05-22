package com.example.natsanai.hotel.Interface;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by natsanai on 5/22/2018.
 */

public interface CarRentAPI {

    @GET("cars")
    Call<ResponseBody> getAllCarRents(

    );

    @POST("rentals/create")
    Call<ResponseBody> createRental(
            @Header("key") String key,
            @Body RequestBody body
    );
}
