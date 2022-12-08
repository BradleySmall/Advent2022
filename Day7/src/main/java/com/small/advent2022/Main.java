package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.small.advent2022.AdventSolution.*;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        NoSpaceLeftOnDevice noSpaceLeftOnDevice = new NoSpaceLeftOnDevice();
        log.info("Hello world!");

        List<String> list = getListFromFile("Day7/input.txt");

        for(String s : list) {
            noSpaceLeftOnDevice.updateDirStruct(s);
        }

        Map<String, Integer> map = noSpaceLeftOnDevice.mapFromNode();


        List<Integer> l = map.values().stream().sorted().filter(v -> v <= 100000).toList();
        log.info("Below 100000 :" + l);
        int sumBottom10K = l.stream().mapToInt(Integer::intValue).sum();
        log.info("Sum below 100000 : " + sumBottom10K);

        int totalAvailable = 70000000;
        int requiredForUpgrade = 30000000;
        int totalUsed = map.get("//");
        int needed = requiredForUpgrade - (totalAvailable - totalUsed);

        log.info("Needed : " + needed);
        log.info("Directory to free : " + map.values().stream().sorted().filter(num -> num >= needed).findFirst().orElse(0));

    }
}