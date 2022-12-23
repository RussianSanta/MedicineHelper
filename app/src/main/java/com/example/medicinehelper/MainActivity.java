package com.example.medicinehelper;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.medicinehelper.JsonObjects.Location;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
        Location location = new Location(latitude, longitude);

//      Пример записи в файл
        try {
            Gson gson = new Gson();
            String jsonText = gson.toJson(location);
            FileOutputStream fos = openFileOutput("location.json", Context.MODE_PRIVATE);
            fos.write(jsonText.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//      Вывод содержимого файла
        try {
            InputStream inputStream = openFileInput("location.json");

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }

                System.out.println(builder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast toast = Toast.makeText(getApplicationContext(),
                latitude + ";  " + longitude, Toast.LENGTH_SHORT);
        toast.show();
    }
}