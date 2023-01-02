package com.sustav.ALGORITHM.challenges.leetcode.easy.merge_sorted_array_88;

/**
 * @author Anton Sustavov
 * @since 2020/09/27
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int subPointer = 0;
        for (int i = m; i < nums1.length; i++) {
            int pubPointer = i;
            nums1[pubPointer] = nums2[subPointer];
            while (pubPointer > 0 && nums1[pubPointer] < nums1[pubPointer-1]) {
                int temp = nums1[pubPointer-1];
                nums1[pubPointer-1] = nums1[pubPointer];
                nums1[pubPointer] = temp;
                pubPointer--;
            }
            subPointer++;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k=nums1.length-1;
        m=m-1;n=n-1;
        while(m>=0&&n>=0)
            nums1[k--]=nums2[n]>nums1[m]?nums2[n--]:nums1[m--];

        while(m>=0)
            nums1[k--]=nums1[m--];

        while(n>=0)
            nums1[k--]=nums2[n--];
    }
}
