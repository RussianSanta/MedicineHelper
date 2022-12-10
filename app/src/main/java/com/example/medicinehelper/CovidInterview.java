package com.example.medicinehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CovidInterview extends AppCompatActivity {
    private TextView name;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private SeekBar seekBar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_interview);
        name = findViewById(R.id.covid_name);
        seekBar1 = findViewById(R.id.covid_seekBar2);
        seekBar2 = findViewById(R.id.covid_seekBar3);
        seekBar3 = findViewById(R.id.covid_seekBar4);
        seekBar4 = findViewById(R.id.covid_seekBar5);
        seekBar5 = findViewById(R.id.covid_seekBar6);
    }

    public void nextButtonClick(View view) {
        System.out.println(seekBar1.getProgress());
        System.out.println(seekBar2.getProgress());
        System.out.println(seekBar3.getProgress());
        System.out.println(seekBar4.getProgress());
        System.out.println(seekBar5.getProgress());
        Intent intent = new Intent();
        intent.setClass(this, InterviewResult.class);
        intent.putExtra("name", name.getText());
        startActivity(intent);
    }
}