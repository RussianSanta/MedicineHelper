package com.example.medicinehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HypertensionInterview extends AppCompatActivity {
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypertension_interview);
        name = findViewById(R.id.hyp_name);
    }

    public void nextButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, InterviewResult.class);
        intent.putExtra("name", name.getText());
        startActivity(intent);
    }
}