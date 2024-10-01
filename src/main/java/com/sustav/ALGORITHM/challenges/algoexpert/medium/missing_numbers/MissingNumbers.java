package com.sustav.ALGORITHM.challenges.algoexpert.medium.missing_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class MissingNumbers {

    public static int[] missingNumbers(int[] nums) {
        var numsList = Arrays.stream(nums)
                .boxed()
                .toList();
        var numsSet = new TreeSet<>(numsList);
        var result = new ArrayList<Integer>();

        for (int i = 1; i <= nums.length + 2; i++) {
            if (!numsSet.contains(i)) result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3};
        System.out.println(Arrays.toString(missingNumbers(nums)));
    }

}
