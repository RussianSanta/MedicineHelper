package com.example.medicinehelper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void consultationButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ConsultationSelection.class);
        startActivity(intent);
    }

    public void emergencyButtonClick(View view) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 10, 10, location -> {
        });

        double latitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();
        double longitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();

        System.out.println(latitude);
        System.out.println(longitude);
    }
}