package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        CampCleanup campCleanup = new CampCleanup();
        log.info("Hello world!");
        List<String> list = getListFromFile("Day4/input.txt");
        log.info(list);
        long count = campCleanup.countContained(list);
        log.info("Fully Contained :" + count);
        long count2 = campCleanup.countOverlapped(list);
        log.info("Overlapped :" + count2);
    }
}