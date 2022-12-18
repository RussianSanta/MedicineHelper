package com.example.medicinehelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ConsultationSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_selection);
    }

    public void therapistButtonClick(View view) {
        System.out.println("Выбран терапевт");
    }

    public void cardiologistButtonClick(View view) {
        System.out.println("Выбран кардиолог");
    }

    public void orthopedistButtonClick(View view) {
        System.out.println("Выбран ортопед");
    }

    public void dutyButtonClick(View view) {
        System.out.println("Выбран дежурный врач");
    }

    public void toInterviewsButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Questions.class);
        startActivity(intent);
    }

    public void toMainPageButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}