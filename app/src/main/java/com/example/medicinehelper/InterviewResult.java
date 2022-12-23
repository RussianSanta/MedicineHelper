package com.example.medicinehelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinehelper.FuzyLogic.DataProvider;
import com.example.medicinehelper.FuzyLogic.Entity.Disease;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;
import com.example.medicinehelper.JsonObjects.Result;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InterviewResult extends AppCompatActivity {
    private TextView name;
    private TextView resultLabel;
    private TextView resultChance;
    private TextView recommendationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_result);
        name = findViewById(R.id.result_name);
        resultLabel = findViewById(R.id.resultLabel);
        resultChance = findViewById(R.id.result_chance);
        recommendationText = findViewById(R.id.recommendationText);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String diseaseName = arguments.get("name").toString();
            String chance = arguments.get("chance").toString();

            if (Double.parseDouble(chance) < 30) {
                name.setText("Проблем не найдено");
                resultLabel.setVisibility(View.INVISIBLE);
                resultChance.setVisibility(View.INVISIBLE);
                recommendationText.setText("Скорее всего вы здоровы. Советуем посетить терапевта в целях профилкатики");
            } else {
                name.setText(diseaseName);
                String resultString = chance + "%";
                String doctorName = arguments.get("doctorName").toString();
                resultChance.setText(resultString);
                recommendationText.setText("Рекомендуем посетить следующего врача - " + doctorName);
            }

            Result result = new Result(diseaseName, chance);
            //      Пример записи в файл
            try {
                Gson gson = new Gson();
                String jsonText = gson.toJson(result);
                FileOutputStream fos = openFileOutput("result.json", Context.MODE_PRIVATE);
                fos.write(jsonText.getBytes(StandardCharsets.UTF_8));
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

//      Вывод содержимого файла
            try {
                InputStream inputStream = openFileInput("result.json");

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
        }
    }

    public void toMainPageButtonClick(View view) {
        for (Disease disease : DataProvider.getDiseases()) {
            disease.setAsked(false);
            disease.setChance(0);
            for (Variable variable : disease.getVariables()) {
                if (!variable.getName().contains("Вероятность"))
                    variable.setAsked(false);
            }
        }
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}