package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.small.advent2022.AdventSolution.getListFromFile;

@Log4j
public class Main {
    public static void main(String[] args) throws IOException {
        SupplyStacks supplyStacks = new SupplyStacks();
        List<String> list = getListFromFile("Day5/input.txt");
        int stackBlockSize = list.indexOf("")+1;

        ArrayList<String> stackList = new ArrayList<>(list.subList(0, stackBlockSize - 1));

        List<String> cmdList = list.subList(stackBlockSize, list.size());

        var stack = supplyStacks.makeStacksFromList(stackList);
        log.info("Initial Stacks: "+formatStack(stack));
        for(String s : cmdList) {
           supplyStacks.doCommand(stack, s, false);
        }

        log.info("Final Stacks: "+formatStack(stack));
        String tips = String.join("", supplyStacks.getStackTip(stack));
        log.info("Tips: " + tips);
    }

    private static String formatStack(List<ArrayList<String>> stack) {

        return ("\n" + stack.toString())
                .replace(" ","")
                .replace("]]]","]]")
                .replace("]]","]]\n")
                .replace("[[[","[[");
    }
}