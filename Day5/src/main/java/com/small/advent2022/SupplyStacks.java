package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j
public class SupplyStacks {
    public List<String> getStackTip(List<ArrayList<String>> stacks) {
        List<String> list = new ArrayList<>();

        for(List<String> l : stacks) {
            if (l.isEmpty())
                list.add("");
            else
                list.add((l.get(l.size()-1))
                        .replace("[", "")
                        .replace("]","")
                        .replace(" ","")
                );
        }
        return list;
    }

    public void doCommand(List<ArrayList<String>> stack, String command, boolean reverse) {
        int cnt = 1;
        int src = 3;
        int dst = 5;


        var cmd = command.split(" ");

        int count = Integer.parseInt(cmd[cnt]);
        int source = Integer.parseInt(cmd[src]) - 1;
        int destination = Integer.parseInt(cmd[dst]) - 1;

        var sList = stack.get(source);
        var dList = stack.get(destination);

        int from = sList.size() - count;
        int to = from + count;
        var lr = sList.subList(from, to);
        if(reverse)
            Collections.reverse(lr);

        dList.addAll(lr);
        sList.subList(from, sList.size()).clear();
    }

    public List<ArrayList<String>> makeStacksFromList(List<String> strings) {
        int stackCount = strings
                .get(strings.size()-1)
                .split("(?<=\\G.{4})", 0)
                .length;

        strings.remove(strings.size()-1);

        ArrayList<ArrayList<String>> stack = new ArrayList<>();
        for(int i =0; i < stackCount; ++i ) {
            stack.add(new ArrayList<>());
        }

        for (String s : strings) {
            String[] result = s.split("(?<=\\G.{4})", 0);

            int i = 0;
            for(String res : result) {
                if(!res.replace(" ","").equals("")) {
                    stack.get(i).add(res);
                }
                i++;
            }
        }
        for(List<String> l : stack) {
            Collections.reverse(l);
        }
        return stack;
    }
}
