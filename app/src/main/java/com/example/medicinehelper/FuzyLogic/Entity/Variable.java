package com.example.medicinehelper.FuzyLogic.Entity;

import java.util.ArrayList;

public class Variable {
    private final ArrayList<Term> terms = new ArrayList<>();
    private String name;
    private int[] dispersion;
    private double belongValue;
    private double discreteValue;
    private String question;
    private boolean asked = false;

    public Variable(String name, int[] dispersion) {
        this.name = name;
        this.dispersion = dispersion;
        this.discreteValue = (double) (dispersion[1] - dispersion[0]) / 3 + dispersion[0];
        question = "Укажите интенсивность симптома " + name;
    }

    public boolean addTerm(String name, int[] dispersion) {
        Term term = new Term(name, dispersion);
        term.setVariable(this);
        return terms.add(term);
    }

    public boolean removeTerm(String name) {
        for (Term term : terms) {
            if (term.name.equals(name)) {
                terms.remove(term);
                return true;
            }
        }
        return false;
    }

    public Term getTerm(int num) {
        return terms.get(num);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getDispersion() {
        return dispersion;
    }

    public void setDispersion(int[] dispersion) {
        this.dispersion = dispersion;
    }

    public double getBelongValue() {
        return belongValue;
    }

    public void setBelongValue(double belongValue) {
        this.belongValue = belongValue;
    }

    public double getDiscreteValue() {
        return discreteValue;
    }

    public void setDiscreteValue(double discreteValue) {
        this.discreteValue = discreteValue;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }

    public static class Term {
        Variable variable;
        private String name;
        private int[] dispersion;
        private double belongValue;

        public Term(String name, int[] dispersion) {
            this.name = name;
            this.dispersion = dispersion;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int[] getDispersion() {
            return dispersion;
        }

        public void setDispersion(int[] dispersion) {
            this.dispersion = dispersion;
        }

        public double getBelongValue() {
            return belongValue;
        }

        public void setBelongValue(double belongValue) {
            this.belongValue = belongValue;
        }

        public Variable getVariable() {
            return variable;
        }

        public void setVariable(Variable variable) {
            this.variable = variable;
        }
    }
}
