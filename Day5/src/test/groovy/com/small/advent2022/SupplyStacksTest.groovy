package com.small.advent2022

import spock.lang.Specification

class SupplyStacksTest extends Specification {
    SupplyStacks supplyStacks
    ArrayList<ArrayList<String>> stacks
    void setup() {
        supplyStacks = new SupplyStacks()
        stacks = new ArrayList<ArrayList<String>> ()
        stacks.add(new ArrayList<String>())
        stacks.get(0).addAll(List.of("[Z]", "[N]"))
        stacks.add(new ArrayList<String>())
        stacks.get(1).addAll(List.of("[M]", "[C]", "[D]"))
        stacks.add(new ArrayList<String>())
        stacks.get(2).addAll(List.of("[P]"))
    }

    def "effect a move"() {
        when:
        supplyStacks.doCommand(stacks, "move 1 from 2 to 1", true)
        List<String> tips = supplyStacks.getStackTip(stacks)
        then:
        tips.join("") == "DCP"

        when:
        supplyStacks.doCommand(stacks, "move 3 from 1 to 3", true)
        tips = supplyStacks.getStackTip(stacks)
        then:
        tips.join("") == "CZ"

        when:
        supplyStacks.doCommand(stacks, "move 2 from 2 to 1", true)
        tips = supplyStacks.getStackTip(stacks)
        then:
        tips.join("") == "MZ"

        when:
        supplyStacks.doCommand(stacks, "move 1 from 1 to 2", true)
        tips = supplyStacks.getStackTip(stacks)
        then:
        tips.join("") == "CMZ"

    }

    def "get tips"() {
        List<String> tips = supplyStacks.getStackTip(stacks)
        expect:
        tips.join("") == "NDP"

    }

    def "make stacks from list"() {
        ArrayList<String> list = List.of(
                "    [D]",
                "[N] [C]",
                "[Z] [M] [P]",
                " 1   2   3"
        )
        var stacks = supplyStacks.makeStacksFromList(list)
        expect:
        stacks.toString() == "[[[Z] , [N] ], [[M] , [C], [D]], [[P]]]"
    }
}
