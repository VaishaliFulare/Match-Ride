package com.example.ridematch;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RideDetailsActivity extends AppCompatActivity {

    private RecyclerView driversRecyclerView;
    private DriversAdapter driversAdapter;
    private ArrayList<RideRequestActivity.Driver> driversList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        driversList = getIntent().getParcelableArrayListExtra("DRIVERS_LIST");

        driversRecyclerView = findViewById(R.id.driversRecyclerView);
        driversRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        driversAdapter = new DriversAdapter(driversList);
        driversRecyclerView.setAdapter(driversAdapter);
    }
}
