package com.example.medicinehelper.FuzyLogic;

public class BelongFunction {
    public static double symmetricTriangleFunction(double a, double c, double x) {
        if (x < a || x > c) return 0;
        double b = (c - a) / 2;
        if (x <= b) {
            return 1 - (b - x) / (b - a);
        } else {
            return 1 - (x - b) / (c - b);
        }
    }

    public static double asymmetricTriangleFunction(double a, double b, double c, double x) {
        if (x < a || x > c) return 0;
        if (x == b) return 1;
        if (x < b) {
            return 1 - (b - x) / (b - a);
        } else {
            return 1 - (x - b) / (c - b);
        }
    }
}
