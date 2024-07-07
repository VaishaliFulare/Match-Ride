package com.example.ridematch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class RideRequestActivity extends AppCompatActivity {

    private TextInputEditText pickupLocation;
    private TextInputEditText dropoffLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_request);

        pickupLocation = findViewById(R.id.pickupLocation);
        dropoffLocation = findViewById(R.id.dropoffLocation);

        findViewById(R.id.submitRideRequestButton).setOnClickListener(view -> {
            String pickup = pickupLocation.getText().toString();
            String dropoff = dropoffLocation.getText().toString();

            if (TextUtils.isEmpty(pickup) || TextUtils.isEmpty(dropoff)) {
                Toast.makeText(RideRequestActivity.this, "Both pickup and drop-off locations are required", Toast.LENGTH_SHORT).show();
            } else {
                // Simulate fetching driver data
                ArrayList<Driver> drivers = new ArrayList<>();
                drivers.add(new Driver("Akshay Patil", "Toyota Prius", "4.9", new LatLng(37.7749, -122.4194)));
                drivers.add(new Driver("John Doe", "Honda Civic", "4.7", new LatLng(37.7849, -122.4094)));
                drivers.add(new Driver("Jane Smith", "Ford Focus", "4.8", new LatLng(37.7649, -122.4294)));
                drivers.add(new Driver("Emily Jones", "Chevrolet Malibu", "4.6", new LatLng(37.7549, -122.4394)));
                drivers.add(new Driver("Michael Brown", "Nissan Altima", "4.5", new LatLng(37.7449, -122.4494)));

                // Pass data to the next activity
                Intent intent = new Intent(RideRequestActivity.this, RideDetailsActivity.class);
                intent.putParcelableArrayListExtra("DRIVERS_LIST", drivers);
                startActivity(intent);
            }
        });
    }

    static class Driver implements Parcelable {
        private String name;
        private String car;
        private String rating;
        private LatLng location;

        public Driver(String name, String car, String rating, LatLng location) {
            this.name = name;
            this.car = car;
            this.rating = rating;
            this.location = location;
        }

        protected Driver(Parcel in) {
            name = in.readString();
            car = in.readString();
            rating = in.readString();
            location = in.readParcelable(LatLng.class.getClassLoader());
        }

        public static final Creator<Driver> CREATOR = new Parcelable.Creator<Driver>() {
            @Override
            public Driver createFromParcel(Parcel in) {
                return new Driver(in);
            }

            @Override
            public Driver[] newArray(int size) {
                return new Driver[size];
            }
        };

        public String getName() {
            return name;
        }

        public String getCar() {
            return car;
        }

        public String getRating() {
            return rating;
        }

        public LatLng getLocation() {
            return location;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(car);
            dest.writeString(rating);
            dest.writeParcelable(location, flags);
        }
    }
}





