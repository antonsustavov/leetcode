package com.sustav.ALGORITHM.challenges.leetcode.easy.shuffle_the_array_1470;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }
}
