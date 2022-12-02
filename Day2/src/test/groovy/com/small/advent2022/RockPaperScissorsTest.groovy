package com.small.advent2022

import spock.lang.Specification

class RockPaperScissorsTest extends Specification {
    def "scoreOneRound"() {
        RockPaperScissors rps = new RockPaperScissors()

        expect:
        rps.scoreOneRound("A Y") == 4
        rps.scoreOneRound("B X") == 1
        rps.scoreOneRound("C Z") == 7
    }
    def "score one game"() {
        RockPaperScissors rps = new RockPaperScissors()
        List<String> list = List.of("A Y", "B X", "C Z")

        expect:
       rps.scoreGame(list) == 12
    }
}
