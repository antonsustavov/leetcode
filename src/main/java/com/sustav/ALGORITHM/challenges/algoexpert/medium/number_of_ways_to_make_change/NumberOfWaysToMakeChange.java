package com.sustav.ALGORITHM.challenges.algoexpert.medium.number_of_ways_to_make_change;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        return numberOfWaysToMakeChangeHelper(n, denoms, 0);
    }

    private static int numberOfWaysToMakeChangeHelper(int n, int[] denoms, int currentTotal) {
        var count = 0;
        if (n == currentTotal) {
            return 1;
        } else if (n < currentTotal) {
            return 0;
        }

        for (int i = 0; i < denoms.length; i++) {
            count = count + numberOfWaysToMakeChangeHelper(n, Arrays.copyOfRange(denoms, i, denoms.length), currentTotal + denoms[i]);
        }

        return count;
    }


    // O(nd) - time, O(n) - space
    public static int numberOfWaysToMakeChangeOther(int n, int[] denoms) {
        if (denoms.length == 0) return 0;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        for (int denom : denoms) {
            for (int amount = 1; amount < ways.length; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }

        return ways[ways.length - 1];
    }
}
