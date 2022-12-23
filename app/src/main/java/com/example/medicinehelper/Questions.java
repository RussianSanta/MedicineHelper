package com.example.medicinehelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinehelper.FuzyLogic.Aggregator;
import com.example.medicinehelper.FuzyLogic.DataProvider;
import com.example.medicinehelper.FuzyLogic.Defuzzifier;
import com.example.medicinehelper.FuzyLogic.Entity.Disease;
import com.example.medicinehelper.FuzyLogic.Entity.Rule;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;
import com.example.medicinehelper.FuzyLogic.Fuzzifier;

import java.util.ArrayList;

public class Questions extends AppCompatActivity {
    private ArrayList<Disease> diseases;
    private Variable activeVariable;

    private TextView questionView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionView = findViewById(R.id.questionView);
        seekBar = findViewById(R.id.seekBar);

        diseases = DataProvider.getDiseases();

//      Выбирается первый случайный вопрос
        int numberOfDisease = (int) (Math.random() * 3);
        ArrayList<Variable> variables = diseases.get(numberOfDisease).getVariables();
        int numberOfVariable = (int) (Math.random() * variables.size() - 1);
        activeVariable = variables.get(numberOfVariable);

//      Подставляются значения под нужную переменную
        questionView.setText(activeVariable.getQuestion());
        seekBar.setMin(activeVariable.getDispersion()[0]);
        seekBar.setMax(activeVariable.getDispersion()[1]);
        seekBar.setProgress((int) activeVariable.getDiscreteValue());
    }

    public void nextButtonClick(View view) {
        activeVariable.setDiscreteValue(seekBar.getProgress());
        activeVariable.setAsked(true);

        double maxChance = 0;
        Disease maxChanceDisease = null;

        for (Disease disease : diseases) {
            ArrayList<Rule> rules = disease.getRules();
            Fuzzifier.fuzzification(rules);
            Aggregator.aggregate(rules);
            double chance = Defuzzifier.defuzzification(rules);
            disease.setChance(chance);

            if (chance > maxChance && !disease.isAsked()) {
                maxChance = chance;
                maxChanceDisease = disease;
            }
        }

        if (maxChanceDisease != null) {
            if (maxChance < 7) {
                for (Variable variable : maxChanceDisease.getVariables()) {
                    if (!variable.isAsked()) {
                        activeVariable = variable;
                        questionView.setText(activeVariable.getQuestion());
                        seekBar.setMin(activeVariable.getDispersion()[0]);
                        seekBar.setMax(activeVariable.getDispersion()[1]);
                        seekBar.setProgress((int) activeVariable.getDiscreteValue());
                        return;
                    }
                }
                maxChanceDisease.setAsked(true);
                nextButtonClick(view);
                return;
            }
        }

        if (maxChanceDisease == null) {
            maxChance = -1;
            for (Disease d : diseases) {
                if (d.getChance() > maxChance) {
                    maxChance = d.getChance();
                    maxChanceDisease = d;
                }
            }
        }
        Intent intent = new Intent();
        intent.setClass(this, InterviewResult.class);

        String chance = String.format("%.2f", maxChance*10);

        intent.putExtra("name", maxChanceDisease.getName());
        intent.putExtra("doctorName", maxChanceDisease.getDoctorName());
        intent.putExtra("chance", chance);
        startActivity(intent);
    }

}