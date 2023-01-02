package com.sustav.ALGORITHM.challenges.algoexpert.easy.non_constructible_change;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] givenCoins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(givenCoins));
    }

    public static int nonConstructibleChange(int[] coins) {
        int currentChangeCreated = 0;

        Arrays.sort(coins);

       for (int coin : coins) {
           if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
           }
           currentChangeCreated += coin;
       }

        return currentChangeCreated + 1;
    }

}
