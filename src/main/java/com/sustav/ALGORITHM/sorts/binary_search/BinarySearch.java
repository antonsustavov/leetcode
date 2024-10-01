package com.sustav.ALGORITHM.challenges.leetcode.algorithm.binary_search;

/**
 * @author Anton Sustavov
 * @since 2020/09/24
 */
public class BinarySearch {

    public static void main(String[] args) {
        final BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[]{0, 3, 5, 8, 10, 33}, 30));
//        System.out.println(solution.binarySearch2(new int[]{0, 3, 5, 8, 10, 33}, 8, 0, 6));
    }

    public int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (num == nums[mid]) {
                return mid;
            }

            if (num < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public int binarySearch2(int[] nums, int num, int left, int right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == num) {
            return mid;
        }

        if (left == right) return 0;

        if (nums[mid] > num) {
            return binarySearch2(nums, num, left, mid);
        } else {
            return binarySearch2(nums, num, mid + 1, right);
        }
    }
}
