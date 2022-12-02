package com.small.advent2022

import spock.lang.Specification


class MainTest extends Specification {
    def "main test "() {
        Main main = new Main()
    expect:
        main.main()

    }
}
