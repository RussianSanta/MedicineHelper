package com.example.medicinehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InterviewSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_selection);
    }

    public void covidButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CovidInterview.class);
        startActivity(intent);
    }

    public void hypertensionButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HypertensionInterview.class);
        startActivity(intent);
    }

    public void arthrosisButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ArthrosisInterview.class);
        startActivity(intent);
    }

    public void backButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ConsultationSelection.class);
        startActivity(intent);
    }

    public void toMainPageButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}