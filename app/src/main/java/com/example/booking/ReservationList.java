package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.models.Reservation;
import com.example.booking.network.GetDataService;
import com.example.booking.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list);

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
                Toast.makeText(ReservationList.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Reservation> reservationList) {
//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this,reservationList);

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.reservations_table);

        for(int i = 1; i < reservationList.size(); i++){

            Reservation res = reservationList.get(i);
            Log.d("Date", res.getDate() + " - " + res.getDinner() + " - " + res.getLunch());


            final TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

            // Creation textView
            final TextView text = new TextView(this);

            text.setText(res.getDate());

            text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            tableRow.addView(text);
            // Creation  button

            Log.d("dd", res.getDinner());

            if(res.getDinner().equals("No")){
                final Button button = new Button(this);
                button.setText("Reserve");
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final TableRow parent = (TableRow) v.getParent();
                        tableLayout.removeView(parent);
                    }
                });
                tableRow.addView(button);

            }else{
                final TextView text2 = new TextView(this);

                text2.setText("Reserved");

                text2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tableRow.addView(text2);
            }


            if(res.getLunch().equals("No")){
                final Button button = new Button(this);
                button.setText("Reserve");
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final TableRow parent = (TableRow) v.getParent();
                        tableLayout.removeView(parent);
                    }
                });
                tableRow.addView(button);

            }else{
                final TextView text2 = new TextView(this);

                text2.setText("Reserved");

                text2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tableRow.addView(text2);
            }


            tableLayout.addView(tableRow);


        }

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
    }
    private void openReservationList() {
        Intent intent = new Intent(this, ReservationList.class);
        startActivity(intent);
    }

}
