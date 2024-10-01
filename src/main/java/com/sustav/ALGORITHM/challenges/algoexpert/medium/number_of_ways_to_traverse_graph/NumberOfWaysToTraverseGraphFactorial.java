package com.sustav.ALGORITHM.challenges.algoexpert.medium.number_of_ways_to_traverse_graph;

public class NumberOfWaysToTraverseGraphFactorial {
    // O(n + m) - time, O(1) - space
    public int numberOfWaysToTraverseGraph(int width, int height) {
        var xDistanceToCorner = width - 1;
        var yDistanceToCorner = height - 1;

        var numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        var denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);

        return numerator / denominator;
    }

    private int factorial(int num) {
        var result = 1;

        for (int i = 2; i < num + 1; i++) {
            result *= i;
        }

        return result;
    }
}
