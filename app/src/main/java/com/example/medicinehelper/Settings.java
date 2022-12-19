package com.example.medicinehelper;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinehelper.FuzyLogic.DataProvider;
import com.example.medicinehelper.FuzyLogic.Entity.Disease;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {
    protected Disease activeDisease;
    private ScrollView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinner = findViewById(R.id.spinner);
        view = findViewById(R.id.main_layout);

        ArrayList<Disease> diseases = DataProvider.getDiseases();


        String[] diseaseNames = diseases.stream().map(Disease::getName).toArray(String[]::new);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, diseaseNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Получаем выбранный объект
                String item = (String) adapterView.getItemAtPosition(i);
                for (Disease d : diseases) {
                    if (d.getName().equals(item)) activeDisease = d;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
}