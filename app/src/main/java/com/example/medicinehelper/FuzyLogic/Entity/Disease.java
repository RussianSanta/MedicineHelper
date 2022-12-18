package com.example.medicinehelper.FuzyLogic.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Disease {
    private final String name;
    private final ArrayList<Rule> rules = new ArrayList<>();
    private ArrayList<Variable> variables = new ArrayList<>();
    private double chance;
    private boolean asked = false;

    public Disease(String name, Variable... variables) {
        this.name = name;
        this.variables.addAll(Arrays.asList(variables));
    }

    public void addRule(int... indexes) {
        if (indexes.length != variables.size())
            throw new IllegalArgumentException("Неверное количество перменных в правиле");
        ArrayList<Variable.Term> terms = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            Variable.Term term = variables.get(i).getTerm(indexes[i]);
            terms.add(term);
        }
        Rule rule = new Rule(terms);
        rules.add(rule);
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public String getName() {
        return name;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}
