package com.small.advent2022;

import java.util.HashSet;
import java.util.Set;

public class TuningTrouble {
    public int locateStartPacket(String buffer) {
        return startOfPacket(buffer, 4);
    }

    private static int startOfPacket(String buffer, int packetIndicatorLength) {
        for (int i = 0; i <= buffer.length() - packetIndicatorLength; ++i) {
            String sub = buffer.substring(i, i + packetIndicatorLength);
            Set<Integer> set = new HashSet<>(sub.chars().boxed().toList());
            if (set.size() == packetIndicatorLength)
                return i + packetIndicatorLength;
        }
        return 0;
    }

    public int locateStartMessage(String buffer) {
        return startOfPacket(buffer, 14);
    }
}
