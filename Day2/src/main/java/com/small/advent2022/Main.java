package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {

    public static void main(String[] args) throws IOException {
        log.info("Hello world!");
        RockPaperScissors rps = new RockPaperScissors();

        List<String> list = getListFromFile("Day2/input.txt");

        int score = rps.scoreGame(list);
        log.info(list);
        log.info(score);
    }
}