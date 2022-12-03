package com.small.advent2022

import spock.lang.Specification

class RucksackReorganizationTest extends Specification {
    def "split string into 2 equal parts"() {
        List<String> list = new RucksackReorganization().splitSack("vJrwpWtwJgWrhcsFMMfFFhFp")

        expect:
        list.get(0) == "vJrwpWtwJgWr"
        list.get(1) == "hcsFMMfFFhFp"
    }

    def "find the duplicate"() {
        List<String> list = new RucksackReorganization().splitSack("vJrwpWtwJgWrhcsFMMfFFhFp")
        def dup = new RucksackReorganization().findDupe(list)
        expect:
        dup == "p"
    }
    def "convert string to priority"() {
        int priority = new RucksackReorganization().strToPriority("a")
        expect:
        priority == 1
    }
    def "calc whole list priority"() {
        List<String> list = List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",

                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw")
        int tot = new RucksackReorganization().calculatePriorityForList(list)
        expect:
        tot == 157
    }

    def "find the badge type for list"() {
        List<String> list = List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg")

        String common = new RucksackReorganization().getCommonFromList(list)
        expect:
        common == "r"
    }
    def "calc whole list badge priority"() {
        List<String> list = List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",

                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw")
        int tot = new RucksackReorganization().calculateBadgePriorityForList(list)
        expect:
        tot == 70
    }
}
