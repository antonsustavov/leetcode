package com.sustav.leetcode.easy.maximum_subarray_53;

/**
 * @author Anton Sustavov
 * @since 2020/09/23
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(solution.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(solution.maxSubArray(new int[]{-2,-1}));
//        System.out.println(solution.maxSubArray3(new int[]{-2,-1}));
//        System.out.println(Math.max(-1, Integer.MIN_VALUE));
    }

    public int maxSubArray4(int[] nums) {
        int maxSub = nums[0], curSum = 0;

        for (int n : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int result = nums[0];
        int sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int result = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public int maxSubArray3(int[] nums) {
        return maxSum(nums,0, nums.length-1);
    }

    private int maxSum(int[] nums, int l, int u) {
        if (l > u) return 0;
        if (l == u) return Math.max(0, nums[l]);

        int m = (l + u) / 2;

        int lmax = 0;
        int sum = 0;

        for (int i = m; i > l; i--) {
            sum += nums[i];
        }
        lmax = Math.max(lmax, sum);

        int rmax = 0;
        sum = 0;
        for (int i = m+1; i < u; i++) {
            sum += nums[i];
        }
        rmax = Math.max(rmax, sum);

        return Math.max(Math.max(lmax+rmax, maxSum(nums, (l+m)/2, (u-m)/2)), Math.max(maxSum(nums, l, m), maxSum(nums, m+1, u)));
    }
}
