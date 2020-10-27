package com.example.booking.network;

import com.example.booking.models.Reservation;
import com.example.booking.models.Reserve;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetDataService {
    @Headers("Content-Type: application/json")

    @GET("reservations.php")
    Call<List<Reservation>> getAllReservations();

    @POST("reserve.php")
    Call<List<Reservation>> reserve(
            @Query("date") String date,
            @Query("type") String type,
            @Query("user_id") String user_id
    );
}
