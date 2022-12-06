package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        log.info("Hello world!");
        CalorieCounting calorieCounting = new CalorieCounting();

        List<String> list = getListFromFile("Day1/input.txt");
        List <Integer> listSum = calorieCounting.getLisOfSums(list);

        log.info("Largest Single Sum = " + listSum.get(0));
        log.info("Top 3 sums = " + listSum.subList(0, 3));
        log.info("Sum of top 3 sums = " + listSum.subList(0, 3).stream().mapToInt(Integer::intValue).sum());
    }
}