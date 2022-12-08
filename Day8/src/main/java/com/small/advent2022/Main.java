package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        log.info("Hello world!");
        TreetopTreeHouse treeHouse = new TreetopTreeHouse();
        List<String> list = getListFromFile("Day8/input.txt");

        int highestScenic = treeHouse.calculateHighestScenicScore(list);
        int allVisible = treeHouse.countAllVisible(list);

        log.info(String.format("All Visible: %d - Highest Scenic Score: %d", allVisible, highestScenic));
    }
}