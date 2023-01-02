package com.sustav.ALGORITHM.challenges.leetcode.easy.search_insert_position_35;

/**
 * @author Anton Sustavov
 * @since 2020/09/22
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
            result++;
        }
        return result;
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return i;
    }
}
