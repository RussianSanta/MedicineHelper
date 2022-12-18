package com.example.medicinehelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InterviewResult extends AppCompatActivity {
    private TextView name;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_result);
        name = findViewById(R.id.result_name);
        result = findViewById(R.id.result_chance);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            name.setText(arguments.get("name").toString());
            String resultString = arguments.get("chance").toString() + "%";
            result.setText(resultString);
        }
    }

    public void toMainPageButtonClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}