package com.example.medicinehelper.FuzyLogic;

import com.example.medicinehelper.FuzyLogic.Entity.Rule;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;

import java.util.ArrayList;

public class Fuzzifier {
    private static double calculateBelong(int[] dispersion, double criteriaValue) {
        return BelongFunction.asymmetricTriangleFunction(dispersion[0], dispersion[1], dispersion[2], criteriaValue);
    }

    public static void fuzzification(ArrayList<Rule> rules) {
        for (Rule rule : rules) {
            ArrayList<Variable.Term> terms = rule.getTerms();
            int i = 0;
            for (Variable.Term term : terms) {
                term.setBelongValue(calculateBelong(term.getDispersion(), term.getVariable().getDiscreteValue()));
            }
        }
    }
}
