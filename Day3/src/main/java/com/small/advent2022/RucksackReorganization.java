package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Log4j
public class RucksackReorganization {
    public int strToPriority(String s) {
        int c = s.charAt(0);

        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else {
            return c - 'A' +  26 + 1;
        }
    }

    public List<String> splitSack(String string) {
        List<String> list = new ArrayList<>();
        int center = string.length() / 2;
        list.add(string.substring(0, center));
        list.add(string.substring(center));
        return list;
    }

    public String findDupe(List<String> list) {
        String s1 = list.get(0);
        String s2 = list.get(1);
        for(Character c : s1.toCharArray()) {
            if (s2.contains(c.toString())) {
                return c.toString();
            }
        }
        return "";
    }

    public int calculatePriorityForList(List<String> list) {
        return list
                .stream()
                .map(this::splitSack)
                .map(this::findDupe)
                .map(this::strToPriority)
                .mapToInt(Integer::intValue).sum();

    }

    public String getCommonFromList(List<String> strings) {
        String s1 = strings.get(0);
        String s2 = strings.get(1);
        String s3 = strings.get(2);

        for (Character c : s1.toCharArray()) {
            if (s2.contains(c.toString()) && s3.contains(c.toString())) {
                return c.toString();
            }
        }
        return "";
    }

    public int calculateBadgePriorityForList(List<String> list) {
        int pageSize = 3;

        return  IntStream
                .range(0, (list.size() + pageSize - 1) / pageSize)
                .mapToObj(i -> list.subList(i * pageSize, Math.min(pageSize * (i + 1), list.size())))
                .map(this::getCommonFromList)
                .map(this::strToPriority)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
