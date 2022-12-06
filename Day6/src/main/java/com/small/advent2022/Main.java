package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        log.info("Hello world!");
        TuningTrouble tuningTrouble = new TuningTrouble();
        List<String> list = getListFromFile("Day6/input.txt");
        for(String s : list) {
            log.info("Start Packet :" + tuningTrouble.locateStartPacket(s));
            log.info("Start Message :" + tuningTrouble.locateStartMessage(s));
        }
    }
}