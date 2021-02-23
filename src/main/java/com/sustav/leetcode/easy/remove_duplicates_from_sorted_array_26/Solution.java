package com.sustav.leetcode.easy.remove_duplicates_from_sorted_array_26;

/**
 * @author Anton Sustavov
 * @since 2020/09/22
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(solution.removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int result = nums.length;
        int i = 1;
        while (i < result) {
            if (nums[i] == nums[i-1]) {
                int j = i;
                while (j < nums.length-1) {
                    nums[j] = nums[j+1];
                    j++;
                }
                result--;
            } else {
                i++;
            }
        }
        return result;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
