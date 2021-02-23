package com.sustav.leetcode.easy.remove_element_27;

/**
 * @author Anton Sustavov
 * @since 2020/09/22
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums.length;
        int i = 0;
        while (i < result) {
            if (nums[i] == val) {
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
}
