package com.example.medicinehelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConsultationSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_selection);
    }

    public void therapistButtonClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выбран терапевт", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void cardiologistButtonClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выбран кардиолог", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void orthopedistButtonClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выбран ортопед", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void dutyButtonClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выбран дежурный врач", Toast.LENGTH_SHORT);
        toast.show();
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