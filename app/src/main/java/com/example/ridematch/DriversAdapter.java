package com.example.ridematch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriverViewHolder> {

    private ArrayList<RideRequestActivity.Driver> driversList;

    public DriversAdapter(ArrayList<RideRequestActivity.Driver> driversList) {
        this.driversList = driversList;
    }

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new DriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        RideRequestActivity.Driver driver = driversList.get(position);
        holder.driverName.setText(driver.getName());
        holder.driverCar.setText(driver.getCar());
        holder.driverRating.setText(driver.getRating());
        LatLng location = driver.getLocation();
        holder.driverLocation.setText("Lat: " + location.latitude + ", Lng: " + location.longitude);
    }

    @Override
    public int getItemCount() {
        return driversList.size();
    }

    static class DriverViewHolder extends RecyclerView.ViewHolder {
        TextView driverName;
        TextView driverCar;
        TextView driverRating;
        TextView driverLocation;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            driverName = itemView.findViewById(R.id.driverName);
            driverCar = itemView.findViewById(R.id.driverCar);
            driverRating = itemView.findViewById(R.id.driverRating);
            driverLocation = itemView.findViewById(R.id.driverLocation);
        }
    }
}

