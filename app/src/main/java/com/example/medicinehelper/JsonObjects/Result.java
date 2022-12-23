package com.example.medicinehelper.JsonObjects;

public class Result {
    private String diseaseName;
    private String chance;

    public Result(String diseaseName, String chance) {
        this.diseaseName = diseaseName;
        this.chance = chance;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public String getChance() {
        return chance;
    }

    @Override
    public String toString() {
        return "Result{" +
                "diseaseName='" + diseaseName + '\'' +
                ", chance='" + chance + '\'' +
                '}';
    }
}
