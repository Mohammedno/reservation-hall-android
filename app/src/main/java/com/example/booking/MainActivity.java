package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button reserv;

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
    }

    private void openReservationList() {
        Intent intent = new Intent(this, ReservationList.class);
        startActivity(intent);
    }


}

