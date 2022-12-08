package com.small.advent2022;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreetopTreeHouse {

    private final Set<String> visibles = new HashSet<>();

    public void resetVisibles() {
        visibles.clear();
    }

    public int countHorizViz(List<String> list, Integer row) {
        int cols = list.get(0).length();

        int tallest = -1;

        for (int i = 0; i < cols; ++i) {
            var a = getHeight(list, row, i);
            if (a > tallest) {
                tallest = a;
                visibles.add("" + row + "-" + i);
            }
        }
        tallest = -1;
        for (int i = cols - 1; i > -1; --i) {
            var a = getHeight(list, row, i);
            if (a > tallest) {
                tallest = a;
                visibles.add("" + row + "-" + i);
            }
        }
        return visibles.size();
    }

    public int countVertViz(List<String> list, Integer column) {
        int rows = list.size();
        int tallest = -1;
        for (int i = 0; i < rows; ++i) {
            var a = getHeight(list, i, column);
            if (a > tallest) {
                tallest = a;
                visibles.add("" + i + "-" + column);
            }
        }
        tallest = -1;
        for (int i = rows - 1; i >= 0; --i) {
            var a = getHeight(list, i, column);
            if (a > tallest) {
                tallest = a;
                visibles.add("" + i + "-" + column);
            }
        }
        return visibles.size();
    }

    public int countAllVisible(List<String> list) {
        int rows = list.size();
        int cols = list.get(0).length();

        for (int r = 0; r < rows; ++r) {
            countVertViz(list, r);
        }
        for (int c = 0; c < cols; ++c) {
            countHorizViz(list, c);
        }

        return visibles.size();
    }

    public int calcScenicScore(List<String> list, Integer row, Integer col) {
        int listWidth = list.get(0).length();
        int listHeight = list.size();

        if (row == 0 || col == 0 || row == listHeight - 1 || col == listWidth - 1) return 0;

        int u = 0;
        int d = 0;
        int rt = 0;
        int lt = 0;

        int height = getHeight(list, row, col);
        for (int r = row - 1; r >= 0; --r) {
            int trHt = getHeight(list, r, col);
            ++u;
            if (trHt >= height) break;
        }
        for (int r = row + 1; r < listHeight; ++r) {
            int trHt = getHeight(list, r, col);
            ++d;
            if (trHt >= height) break;
        }
        for (int c = col - 1; c >= 0; --c) {
            int trHt = getHeight(list, row, c);
            ++lt;
            if (trHt >= height) break;
        }
        for (int c = col + 1; c < listWidth; ++c) {
            int trHt = getHeight(list, row, c);
            ++rt;
            if (trHt >= height) break;
        }
        return lt * rt * u * d;
    }

    private int getHeight(List<String> list, Integer row, Integer col) {
        return Character.getNumericValue(list.get(row).charAt(col));
    }

    public Integer calculateHighestScenicScore(List<String> list) {
        int listHeight = list.size();
        int listWidth = list.get(0).length();

        int retVal = 0;
        for (int row = 0; row < listHeight; ++row) {
            for (int col = 0; col < listWidth; ++col) {
                int score = calcScenicScore(list, row, col);
                if (score > retVal) retVal = score;
            }
        }
        return retVal;
    }
}
