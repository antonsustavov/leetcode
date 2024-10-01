package com.sustav.ALGORITHM.challenges.algoexpert.medium.number_of_ways_to_traverse_graph;

public class NumberOfWaysToTraverseGraphDynamic {
    // O(n * m) - time, O(n * m) - space
    public int numberOfWaysToTraverseGraph(int width, int height) {
        var ways = new int[height + 1][width + 1];

        for (int heightIdx = 1; heightIdx < height + 1; heightIdx++) {
            for (int widthIdx = 1; widthIdx < width + 1; widthIdx++) {
                if (heightIdx == 1 || widthIdx == 1) {
                    ways[heightIdx][widthIdx] = 1;
                } else {
                    var waysLeft = ways[heightIdx][widthIdx - 1];
                    var waysUp = ways[heightIdx - 1][widthIdx];
                    ways[heightIdx][widthIdx] = waysLeft + waysUp;
                }
            }
        }

        return ways[height][width];
    }
}
