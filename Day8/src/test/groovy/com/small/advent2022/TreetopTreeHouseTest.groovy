package com.small.advent2022

import groovy.util.logging.Log4j
import spock.lang.Specification

import static com.small.advent2022.AdventSolution.getListFromFile

@Log4j
class TreetopTreeHouseTest extends Specification {
    TreetopTreeHouse treeHouse
    List<String> list
    void setup() {
        treeHouse = new TreetopTreeHouse()
        list = getListFromFile("test_input.txt")
    }
    def "count all visibility for list"(){
        expect:
        21 == treeHouse.countAllVisible(list)
    }

    def "get highest scenicScore"(){
        expect:
        8 == treeHouse.calculateHighestScenicScore(list)
    }
    def "calc scenicScore"() {
        def ht = list.size()-1
        def wt = list.get(0).length()-1

        expect:
        0 == treeHouse.calcScenicScore(list, 0, 1)
        0 == treeHouse.calcScenicScore(list, 0, 0)
        0 == treeHouse.calcScenicScore(list, 1, 0)
        0 == treeHouse.calcScenicScore(list, 1, wt)
        0 == treeHouse.calcScenicScore(list, ht, 1)
        0 == treeHouse.calcScenicScore(list, ht, wt)
        1 == treeHouse.calcScenicScore(list, 1, 1)
        4 == treeHouse.calcScenicScore(list, 1, 2)
        8 == treeHouse.calcScenicScore(list, 3, 2)
    }

    def "horizontal visibility"() {
        expect:
        3 == treeHouse.countHorizViz(list,0)
        treeHouse.resetVisibles()
        4 == treeHouse.countHorizViz(list,1)
        treeHouse.resetVisibles()
        4 == treeHouse.countHorizViz(list,2)
        treeHouse.resetVisibles()
        3 == treeHouse.countHorizViz(list,3)
        treeHouse.resetVisibles()
        4 == treeHouse.countHorizViz(list,4)
    }

    def "vertical visibility"() {
        expect:
        3 == treeHouse.countVertViz(list,0)
        treeHouse.resetVisibles()
        3 == treeHouse.countVertViz(list,1)
        treeHouse.resetVisibles()
        4 == treeHouse.countVertViz(list,2)
        treeHouse.resetVisibles()
        2 == treeHouse.countVertViz(list,3)
        treeHouse.resetVisibles()
        3 == treeHouse.countVertViz(list,4)
    }

    def "should show list is 5 x 5"() {
        expect:
        5 == list.size()
        5 == list.get(0).size()
    }
}
