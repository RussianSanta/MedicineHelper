package com.example.medicinehelper.FuzyLogic;

import com.example.medicinehelper.FuzyLogic.Entity.Rule;

import java.util.ArrayList;

//Для дефаззификации выбран метод центра максимумов
public class Defuzzifier {
    public static double defuzzification(ArrayList<Rule> rules) {
//      Собираю все правила с максимальными отсечениями
        ArrayList<Rule> maxRules = new ArrayList<>();
        double max = 0;
        for (Rule rule : rules) {
            if (rule.getBelongValue() > max) {
                max = rule.getBelongValue();
                maxRules = new ArrayList<>();
                maxRules.add(rule);
            } else if (rule.getBelongValue() == max) {
                maxRules.add(rule);
            }
        }

        double sum = 0;
        double count = 0;

//          Расчет длин отсечений в графике функции принадлежности.
//          Для расчета используется факт, что в подобных треугольниках стороны соотносятся одинаково
        for (Rule rule : maxRules) {
            int[] dispersion = rule.getResult().getDispersion();
//          Координата по X верхней вершины треугольника в графике функции принадлежности
            double triangleHeightX = dispersion[1];

//          Высота верхнего вложенного подобного треугольника
            double topHeight = 1 - rule.getBelongValue();

//          Длина левой части основания большого треугольника
            double bottomLeftBaseLength = dispersion[1] - dispersion[0];
//          Расчет длины левой части основания вложенного подобного треугольника
            double topLeftBottomLength = topHeight * bottomLeftBaseLength;
//          Длина правой части основания большого треугольника
            double bottomRightBaseLength = dispersion[2] - dispersion[1];
//          Расчет длины правой части основания вложенного подобного треугольника
            double topRightBottomLength = topHeight * bottomRightBaseLength;

            double topLeftX = dispersion[1] - topLeftBottomLength;
            double topRightX = dispersion[1] + topRightBottomLength;

            sum += topLeftX;
            sum += topRightX;
            count += 2;
        }

        return sum / count;
    }
}
