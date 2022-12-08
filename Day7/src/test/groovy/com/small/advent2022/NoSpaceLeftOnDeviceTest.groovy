package com.small.advent2022

import spock.lang.Ignore
import spock.lang.Specification

class NoSpaceLeftOnDeviceTest extends Specification {
    NoSpaceLeftOnDevice noSpaceLeftOnDevice
    void setup() {
        noSpaceLeftOnDevice = new NoSpaceLeftOnDevice()
    }

    def "show dir structure"() {

       noSpaceLeftOnDevice.updateDirStruct("\$ cd /")
       noSpaceLeftOnDevice.updateDirStruct("\$ ls")
       noSpaceLeftOnDevice.updateDirStruct("dir a")
       noSpaceLeftOnDevice.updateDirStruct("14848514 b.txt")
       noSpaceLeftOnDevice.updateDirStruct("8504156 c.dat")
       noSpaceLeftOnDevice.updateDirStruct("dir d")
       noSpaceLeftOnDevice.updateDirStruct("\$ cd a")
       noSpaceLeftOnDevice.updateDirStruct("\$ ls")
       noSpaceLeftOnDevice.updateDirStruct("dir e")
       noSpaceLeftOnDevice.updateDirStruct("29116 f")
       noSpaceLeftOnDevice.updateDirStruct("2557 g")
       noSpaceLeftOnDevice.updateDirStruct("62596 h.lst")
       noSpaceLeftOnDevice.updateDirStruct("\$ cd e")
       noSpaceLeftOnDevice.updateDirStruct("\$ ls")
       noSpaceLeftOnDevice.updateDirStruct("584 i")
       noSpaceLeftOnDevice.updateDirStruct("\$ cd ..")
       noSpaceLeftOnDevice.updateDirStruct("\$ cd ..")
       noSpaceLeftOnDevice.updateDirStruct("\$ cd d")
       noSpaceLeftOnDevice.updateDirStruct("\$ ls")
       noSpaceLeftOnDevice.updateDirStruct("4060174 j")
       noSpaceLeftOnDevice.updateDirStruct("8033020 d.log")
       noSpaceLeftOnDevice.updateDirStruct("5626152 d.ext")
       noSpaceLeftOnDevice.updateDirStruct("7214296 k")
        expect:
        noSpaceLeftOnDevice.show()
    }
}
