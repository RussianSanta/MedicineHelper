package com.example.medicinehelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinehelper.FuzyLogic.DataProvider;
import com.example.medicinehelper.FuzyLogic.Entity.Disease;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;

public class InterviewResult extends AppCompatActivity {
    private TextView name;
    private TextView resultLabel;
    private TextView result;
    private TextView recommendationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_result);
        name = findViewById(R.id.result_name);
        resultLabel = findViewById(R.id.resultLabel);
        result = findViewById(R.id.result_chance);
        recommendationText = findViewById(R.id.recommendationText);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {

            if ((double) arguments.get("chance") < 30) {
                name.setText("Проблем не найдено");
                resultLabel.setVisibility(View.INVISIBLE);
                result.setVisibility(View.INVISIBLE);
                recommendationText.setText("Скорее всего вы здоровы. Советуем посетить терапевта в целях профилкатики");
            } else {
                name.setText(arguments.get("name").toString());
                String resultString = arguments.get("chance").toString() + "%";
                String doctorName = arguments.get("doctorName").toString();
                result.setText(resultString);
                recommendationText.setText("Рекомендуем посетить следующего врача - " + doctorName);
            }
        }
    }

    public void toMainPageButtonClick(View view) {
        for (Disease disease: DataProvider.getDiseases()) {
            disease.setAsked(false);
            disease.setChance(0);
            for (Variable variable:disease.getVariables()) {
                variable.setAsked(false);
            }
        }
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}