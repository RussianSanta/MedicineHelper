package com.example.medicinehelper.FuzyLogic;

import com.example.medicinehelper.FuzyLogic.Entity.Disease;
import com.example.medicinehelper.FuzyLogic.Entity.Variable;

import java.util.ArrayList;

//Пока нет базы данных этот класс будет хранить внутри себя захардкоженые данные. При добавлении базы изменить логику
public class DataProvider {
    private static ArrayList<Disease> diseases;

    //  Хардкод болезней, потом можно будет хранить все в бд
    private static void genDisease() {
//      Входные переменные
        Variable fever = new Variable("Лихорадка", new int[]{0, 10});
        Variable bodyPain = new Variable("Боль в теле", new int[]{0, 10});
        Variable headache = new Variable("Головная боль", new int[]{0, 10});
        Variable sweating = new Variable("Потоотделение", new int[]{0, 10});
        Variable cough = new Variable("Кашель", new int[]{0, 10});
        Variable wheeze = new Variable("Одышка", new int[]{0, 10});
        Variable smoking = new Variable("Курение", new int[]{0, 10});
        Variable nausea = new Variable("Тошнота", new int[]{0, 10});
        Variable physicalWork = new Variable("Физические нагрузки", new int[]{0, 10});
        Variable mobility = new Variable("Сидячий образ жизни", new int[]{0, 10});
        Variable walkingPain = new Variable("Дискомфорт при ходьбе", new int[]{0, 10});

//      Выходные переменные
        Variable covidChance = new Variable("Вероятность болезни COVID-19", new int[]{0, 10});
        Variable hypertensionChance = new Variable("Вероятность болезни Гипертония", new int[]{0, 10});
        Variable arthrosisChance = new Variable("Вероятность болезни Артроз", new int[]{0, 10});

        covidChance.setAsked(true);
        hypertensionChance.setAsked(true);
        arthrosisChance.setAsked(true);

//      Наполненние термами переменных
        fever.addTerm("Нет", new int[]{0, 1, 6});
        fever.addTerm("Да", new int[]{5, 9, 10});

        bodyPain.addTerm("Нет", new int[]{0, 1, 5});
        bodyPain.addTerm("Да", new int[]{4, 9, 10});

        headache.addTerm("Нет", new int[]{0, 1, 6});
        headache.addTerm("Да", new int[]{5, 9, 10});

        sweating.addTerm("Нет", new int[]{0, 1, 5});
        sweating.addTerm("Да", new int[]{4, 9, 10});

        cough.addTerm("Нет", new int[]{0, 3, 7});
        cough.addTerm("Да", new int[]{6, 9, 10});

        wheeze.addTerm("Нет", new int[]{0, 1, 4});
        wheeze.addTerm("Да", new int[]{3, 7, 10});

        smoking.addTerm("Нет", new int[]{0, 1, 5});
        smoking.addTerm("Да", new int[]{4, 8, 10});

        nausea.addTerm("Нет", new int[]{0, 1, 4});
        nausea.addTerm("Да", new int[]{3, 7, 10});

        physicalWork.addTerm("Нет", new int[]{0, 1, 6});
        physicalWork.addTerm("Да", new int[]{6, 9, 10});

        mobility.addTerm("Нет", new int[]{0, 1, 6});
        mobility.addTerm("Да", new int[]{6, 9, 10});

        walkingPain.addTerm("Нет", new int[]{0, 1, 4});
        walkingPain.addTerm("Да", new int[]{3, 7, 10});

        covidChance.addTerm("Вероятно нет", new int[]{0, 1, 4});
        covidChance.addTerm("50/50", new int[]{4, 1, 6});
        covidChance.addTerm("Вероятно да", new int[]{6, 9, 10});

        hypertensionChance.addTerm("Вероятно нет", new int[]{0, 1, 4});
        hypertensionChance.addTerm("50/50", new int[]{4, 5, 6});
        hypertensionChance.addTerm("Вероятно да", new int[]{6, 9, 10});

        arthrosisChance.addTerm("Вероятно нет", new int[]{0, 1, 4});
        arthrosisChance.addTerm("50/50", new int[]{4, 5, 6});
        arthrosisChance.addTerm("Вероятно да", new int[]{6, 9, 10});

        Disease covid = new Disease("Covd-19", fever, bodyPain, headache, sweating, cough, covidChance);
        Disease hypertension = new Disease("Гипертония", wheeze, smoking, headache, nausea, hypertensionChance);
        Disease arthrosis = new Disease("Артроз", physicalWork, smoking, mobility, walkingPain, arthrosisChance);

//      На вход подаются номера термов в соотвествии с порядком их добавления.
//      Последовательность соответствует последовательности добавления переменных для болезни
        covid.addRule(0, 0, 0, 0, 0, 0);
        covid.addRule(1, 0, 0, 0, 0, 0);
        covid.addRule(0, 0, 1, 0, 1, 0);
        covid.addRule(1, 1, 1, 0, 0, 1);
        covid.addRule(0, 1, 1, 1, 0, 1);
        covid.addRule(0, 1, 1, 0, 1, 1);
        covid.addRule(1, 1, 0, 1, 1, 2);
        covid.addRule(1, 1, 1, 1, 1, 2);

        hypertension.addRule(0, 0, 0, 0, 0);
        hypertension.addRule(1, 0, 0, 0, 0);
        hypertension.addRule(0, 1, 1, 0, 0);
        hypertension.addRule(1, 1, 0, 0, 0);
        hypertension.addRule(0, 1, 1, 1, 1);
        hypertension.addRule(1, 1, 1, 0, 1);
        hypertension.addRule(1, 0, 1, 1, 2);
        hypertension.addRule(1, 1, 0, 1, 2);
        hypertension.addRule(1, 1, 1, 1, 2);

        arthrosis.addRule(0, 0, 0, 0, 0);
        arthrosis.addRule(1, 0, 0, 0, 0);
        arthrosis.addRule(0, 1, 1, 0, 0);
        arthrosis.addRule(1, 1, 0, 0, 0);
        arthrosis.addRule(1, 1, 1, 0, 1);
        arthrosis.addRule(1, 0, 0, 1, 1);
        arthrosis.addRule(1, 1, 0, 1, 2);
        arthrosis.addRule(1, 1, 1, 1, 2);

        diseases = new ArrayList<>();
        diseases.add(covid);
        diseases.add(hypertension);
        diseases.add(arthrosis);
    }

    public static ArrayList<Disease> getDiseases() {
        if (diseases == null) genDisease();
        return diseases;
    }
}
