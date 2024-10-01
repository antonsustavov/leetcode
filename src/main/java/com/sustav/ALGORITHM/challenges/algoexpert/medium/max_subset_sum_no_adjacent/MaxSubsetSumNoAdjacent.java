package com.sustav.ALGORITHM.challenges.algoexpert.medium.max_subset_sum_no_adjacent;

public class MaxSubsetSumNoAdjacent {
    // O(n) - time, O(n) - space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        int[] buffer = new int[3];
        buffer[0] = array[0];
        buffer[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            buffer[2] = Math.max(array[i] + buffer[0], buffer[1]);
            buffer[0] = buffer[1];
            buffer[1] = buffer[2];
        }

        return buffer[1];
    }

    // O(n) - time, O(1) - space
    public static int maxSubsetSumNoAdjacentOSpace(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        var second = array[0];
        var first = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            var current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }

        return first;
    }
}
