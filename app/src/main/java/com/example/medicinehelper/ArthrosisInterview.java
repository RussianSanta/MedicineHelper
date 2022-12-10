package com.example.medicinehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArthrosisInterview extends AppCompatActivity {
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arthrosis_interview);
        name = findViewById(R.id.art_name);
    }

    public void nextButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, InterviewResult.class);
        intent.putExtra("name", name.getText());
        startActivity(intent);
    }
}