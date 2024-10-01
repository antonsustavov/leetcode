package com.sustav.ALGORITHM.challenges.algoexpert.medium.zero_sum_subarray;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    // O(n) - time, O(n) - space
    public boolean zeroSumSubarray(int[] nums) {
        Set<Object> sums = new HashSet<>(Set.of(0));
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sums.contains(currentSum)) {
                return true;
            } else {
                sums.add(currentSum);
            }
        }

        return false;
    }

}
