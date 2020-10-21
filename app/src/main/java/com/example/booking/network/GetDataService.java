package com.example.booking.network;

import com.example.booking.models.Reservation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("reservations.php")
    Call<List<Reservation>> getAllReservations();
}
