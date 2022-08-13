package com.company.utils;

import java.time.LocalDate;
import java.util.Random;

public class RandomDateGenerator {
    public LocalDate getRandomDate(int startYear, int endYear){
        int difference = endYear - startYear;
        int randomYearDelta = new Random().nextInt(difference-1);
        int randomYear = startYear + randomYearDelta;
        int randomMonth = new Random().nextInt(11)+1;
        int randomDay = new Random().nextInt(28)+1; 
        return  LocalDate.of(randomYear, randomMonth , randomDay);

    }




}
