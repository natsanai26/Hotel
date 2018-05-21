package com.example.natsanai.hotel.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
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
            @Query("carTypeId") int carTypeId
    );
}
