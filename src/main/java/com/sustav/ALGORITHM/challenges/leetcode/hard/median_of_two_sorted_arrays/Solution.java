package com.sustav.ALGORITHM.challenges.leetcode.hard.median_of_two_sorted_arrays;

/**
 * @author Anton Sustavov
 * @since 2020/09/14
 */
public class Solution {
    public static void main(String[] args) {
//        int[] num1 = new int[]{1, 3};
//        int[] num2 = new int[]{2};
//        int[] num1 = new int[]{1, 2};
//        int[] num2 = new int[]{3, 4};
//        int[] num1 = new int[]{0, 0};
//        int[] num2 = new int[]{0, 0};
//        int[] num1 = new int[]{2};
//        int[] num2 = new int[]{};
//        int[] num1 = new int[]{0,0,0,0,0};
//        int[] num2 = new int[]{-1,0,0,0,0,0,1};
        int[] num1 = new int[]{1,3};
        int[] num2 = new int[]{2,7};
        final Solution solution = new Solution();
//        solution.findMedianSortedArrays(num1, num2);
        System.out.println(solution.findMedianSortedArrays2(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 > 0) {
            return nums2[0];
        } else if (len2 == 0 && len1 > 0) {
            return nums1[0];
        } else if (len2 == 0 && len1 == 0) {
            return 0;
        }
        if (nums2[0] < nums1[0]) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int index = findMax(nums1, 0, nums1.length-1, nums2[0]);
        int[] result = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, result, 0, index+1);
        System.arraycopy(nums2, 0, result, index+1, nums2.length);
        if (index < nums1.length-1) {
            System.arraycopy(nums1, nums2.length+index, result, nums1.length, nums1.length-nums1.length+index+1);
        }

        if (result.length % 2 == 0) {
            median = (double) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        } else {
            median = result[result.length / 2];
        }
        return median;
    }

    public int findMax(int[] source, int min, int max, int key) {
        if (max >= min) {
            int mid = min + (max - min) / 2;
            if ((source[mid] < key && mid == max) || (source[mid] < key && source[mid + 1] > key)) {
                return mid;
            }
            if (source[mid] >= key) {
                return findMax(source, min, mid - 1, key);//search in left subarray
            } else {
                return findMax(source, mid + 1, max, key);//search in right subarray
            }
        }
        return source.length-1;

    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
