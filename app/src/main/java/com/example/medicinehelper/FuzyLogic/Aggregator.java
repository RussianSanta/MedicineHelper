package com.example.medicinehelper.FuzyLogic;

import com.example.medicinehelper.FuzyLogic.Entity.Rule;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;

import java.util.ArrayList;

public class Aggregator {
    private static double findMinimum(Rule rule) {
        double min = 1;
        for (Variable.Term term : rule.getTerms()) {
            if (term.getBelongValue() < min) min = term.getBelongValue();
        }
        return min;
    }

    public static void aggregate(ArrayList<Rule> fuzzedRules) {
        for (Rule fuzzedRule : fuzzedRules) {
            fuzzedRule.setBelongValue(findMinimum(fuzzedRule));
        }
    }
}
