package com.small.advent2022

import spock.lang.Specification

class MainTest extends Specification {
    Main main
    void setup() {
        main = new Main()
    }

    void cleanup() {
        // no cleanup
    }

    def "Main"() {
        expect:
        main.main()
    }
}
