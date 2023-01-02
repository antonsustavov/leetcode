package com.sustav.ALGORITHM.challenges.leetcode.easy.two_sum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Sustavov
 * @since 2020/09/11
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
        int[] nums = new int[]{0, 4, 3, 0};
//        int target = 9;
        int target = 0;
        final Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum2(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] <= target && nums[j] <= target) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
//                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
