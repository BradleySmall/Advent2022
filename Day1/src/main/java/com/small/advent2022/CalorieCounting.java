package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

@Log4j
public class CalorieCounting {

    public List<String> getListFromFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        log.info( path.toAbsolutePath());
        try(Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }

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
