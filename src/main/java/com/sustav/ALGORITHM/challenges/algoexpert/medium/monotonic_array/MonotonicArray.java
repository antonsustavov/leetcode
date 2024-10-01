package com.sustav.ALGORITHM.challenges.algoexpert.medium.monotonic_array;

public class MonotonicArray {
    //O(n) - time, O(1) - space
    public boolean isMonotonic(int[] array) {
        if (array.length <= 2) return true;

        var direction = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breakDirection(direction, array[i - 1], array[i])) return false;
        }

        return true;
    }

    private boolean breakDirection(int direction, int prev, int cur) {
        var diff = cur - prev;
        if (direction > 0) {
            return diff < 0;
        }
        return diff > 0;
    }

    //O(n) - time, O(1) - space
    public boolean isMonotonic2(int[] array) {
        if (array.length <= 2) return true;

        var isNonDecreasing = true;
        var isNonIncreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) isNonDecreasing = false;
            if (array[i] > array[i - 1]) isNonIncreasing = false;
        }

        return isNonDecreasing || isNonIncreasing;
    }

    public boolean isMonotonic3(int[] array) {
        if (array.length <= 2) return true;

        var isIncreasing = array[0] < array[1];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1] && !isIncreasing) return false;
            if (array[i] > array[i + 1] && isIncreasing) return false;
        }

        return true;
    }
}
