package com.example.medicinehelper.FuzyLogic.Entity;

import java.util.ArrayList;

public class Rule {
    private ArrayList<Variable.Term> terms;
    private Variable.Term result;
    private double belongValue;

    public Rule(ArrayList<Variable.Term> input) {
        result = input.get(input.size() - 1);
        input.remove(result);
        this.terms = input;
    }

    public ArrayList<Variable.Term> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<Variable.Term> terms) {
        this.terms = terms;
    }

    public Variable.Term getResult() {
        return result;
    }

    public void setResult(Variable.Term result) {
        this.result = result;
    }

    public double getBelongValue() {
        return belongValue;
    }

    public void setBelongValue(double belongValue) {
        this.belongValue = belongValue;
    }
}
