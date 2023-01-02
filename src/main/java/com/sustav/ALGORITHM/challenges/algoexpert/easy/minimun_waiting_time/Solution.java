package com.sustav.ALGORITHM.challenges.algoexpert.easy.minimun_waiting_time;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] times = {5, 1, 4};
        int[] times2 = {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(times));
        System.out.println(minimumWaitingTime(times2));
    }

    public static int minimumWaitingTime(int[] queries) {
        int result = 0;
        Arrays.sort(queries);

        for (int i = 0; i < queries.length; i++) {
            int queriesLeft = queries.length - (i + 1);
            result += queriesLeft * queries[i];
        }
        return result;
    }
}
