package com.sustav.ALGORITHM.challenges.algoexpert.medium.number_of_ways_to_traverse_graph;

public class NumberOfWaysToTraverseGraph {
    // O(2 ^ (n + m)) - time, O(n + m) - space
    public int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }

        return numberOfWaysToTraverseGraph(width - 1, height) + numberOfWaysToTraverseGraph(width, height - 1);
    }
}
