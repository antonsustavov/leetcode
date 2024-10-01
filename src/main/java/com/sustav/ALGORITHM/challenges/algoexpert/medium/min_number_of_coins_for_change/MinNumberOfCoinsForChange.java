package com.sustav.ALGORITHM.challenges.algoexpert.medium.min_number_of_coins_for_change;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (denoms.length == 0) return -1;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < ways.length; amount++) {
                if (denom <= amount) {
                    if (ways[amount - denom] < Integer.MAX_VALUE) {
                        ways[amount] = Math.min(ways[amount], ways[amount - denom] + 1);
                    }
                }
            }
        }

        return ways[n] == Integer.MAX_VALUE ? -1 : ways[n];
    }
}
