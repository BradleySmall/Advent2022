package com.small.advent2022

import spock.lang.Specification

class CalorieCountingTest extends Specification {
    CalorieCounting calorieCounting
    void setup() {
        calorieCounting = new CalorieCounting()
    }

    def "GetListFromFile"() {
        def list = calorieCounting.getListFromFile("test_input.txt")

        expect:
        list == ["1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000"]
    }

    def "GetLisOfSums"() {
        def list = calorieCounting.getListFromFile("test_input.txt")
        def listOfSums = calorieCounting.getLisOfSums(list)

        expect:
        listOfSums == [24000, 11000, 10000, 6000, 4000]
    }
    def "should show max cals = 24000"() {
        def list = calorieCounting.getListFromFile("test_input.txt")
        def listOfSums = calorieCounting.getLisOfSums(list)
        def maxCals = listOfSums.get(0)

        expect:
        maxCals == 24000
    }
    def "should show top3 sum cals = 45000"() {
        def list = calorieCounting.getListFromFile("test_input.txt")
        def listOfSums = calorieCounting.getLisOfSums(list)
        def top3Sum = listOfSums.subList(0,3).sum()

        expect:
        top3Sum == 45000
    }
}
