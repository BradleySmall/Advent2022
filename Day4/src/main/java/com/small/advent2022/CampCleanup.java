package com.small.advent2022;

import java.util.List;

public class CampCleanup {
    public Boolean isContained(String string) {
        var v = string.split(",");
        var v1 = v[0].split("-");
        var v2 = v[1].split("-");
        int b1 = Integer.parseInt(v2[0]);
        int b2 = Integer.parseInt(v1[0]);
        int e1 = Integer.parseInt(v2[1]);
        int e2 = Integer.parseInt(v1[1]);

        if (b1 <= b2 && e1 >= e2) {
            return true;
        }
        return b2 <= b1 && e2 >= e1;
    }
    public Boolean isOverLapped(String string) {
        var v = string.split(",");
        var v1 = v[0].split("-");
        var v2 = v[1].split("-");
        int b1 = Integer.parseInt(v2[0]);
        int e1 = Integer.parseInt(v2[1]);
        int b2 = Integer.parseInt(v1[0]);
        int e2 = Integer.parseInt(v1[1]);

        if (b1 >= b2 && b1 <= e2) {
            return true;
        }
        if (e1 >= b2 && e1 <= e2) {
            return true;
        }

        if (b2 >= b1 && b2 <= e1) {
            return true;
        }
        return e2 >= b1 && e2 <= e1;
    }

    public long countContained(List<String> list) {
        return list.stream()
                .filter(this::isContained)
                .count();
    }

    public long countOverlapped(List<String> list) {
        return list.stream()
                .filter(this::isOverLapped)
                .count();
    }
}
