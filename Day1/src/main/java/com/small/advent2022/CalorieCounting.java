package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Log4j
public class CalorieCounting {

    public List<Integer> getLisOfSums(List<String> list) {
        List<Integer> elvesCalories = new ArrayList<>();

        int sum = 0;
        for (String calorie : list) {
            if (calorie.equals("")) {
                elvesCalories.add(sum);
                sum=0;
            } else {
                sum += Integer.parseInt(calorie);
            }
        }
        if (sum != 0) {
            elvesCalories.add(sum);
        }
        return elvesCalories.stream().sorted(Comparator.reverseOrder()).toList();
    }

}
