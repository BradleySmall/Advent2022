package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello world!");

        try {
            List<String> list = getListFromFile("Day3/test_input.txt");
            log.info(list);
        } catch (IOException ioException) {
            log.info(ioException.getMessage());
        }
    }
}