package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.example.booking.adapter.CustomAdapter;
import com.example.booking.models.Reservation;
import com.example.booking.network.GetDataService;
import com.example.booking.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button reserv;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
//    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        reserv = (Button) findViewById(R.id.reserv);
        reserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReservationList();
            }
        });


        Log.d("MyTaG", "Hello, World! 9090");

//        progressDoalog.setMessage("Loading....");
//        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Reservation>> call = service.getAllReservations();
        call.enqueue(new Callback<List<Reservation>>() {
            @Override
            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> response) {
//                progressDoalog.dismiss();

                Log.e("Res:", response.toString());

                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Reservation>> call, Throwable t) {
//                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Reservation> reservationList) {
//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this,reservationList);
        Reservation res = reservationList.get(0);
        Log.d("List123", res.getDate());

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
    }
    private void openReservationList() {
        Intent intent = new Intent(this, ReservationList.class);
        startActivity(intent);
    }

    public void logout(View v){
        // Delete all SharedPref

        /*  SharedPreferences  */
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("user");
        editor.clear();
        editor.commit();
        editor.apply();
        /*  ./SharedPreferences  */

        // Redirect to login page
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);

    }

}

