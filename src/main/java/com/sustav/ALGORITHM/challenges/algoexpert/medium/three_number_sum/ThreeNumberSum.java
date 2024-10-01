package com.sustav.ALGORITHM.challenges.algoexpert.medium.three_number_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    // O(n^2) - time, O(n) - space
    public List<Integer[]> threeNumberSum(int[] array, int targetSum) {
//        Arrays.sort(Arrays.stream(array).boxed().toArray(Integer[]::new), Collections.reverseOrder());
//        Integer[] integers = Arrays.stream(array).boxed().sorted().toArray(Integer[]::new);
//        int[] ints = Arrays.stream(array).sorted().toArray();
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
