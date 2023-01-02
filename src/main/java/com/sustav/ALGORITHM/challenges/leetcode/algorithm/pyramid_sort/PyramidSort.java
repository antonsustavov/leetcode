package com.sustav.ALGORITHM.challenges.leetcode.algorithm.pyramid_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/11/27
 */
public class PyramidSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final PyramidSort pyramidSort = new PyramidSort();
        System.out.println(Arrays.toString(ints));
        pyramidSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private void sort(int[] arr) {
        int last_element = arr.length-1;
        while (last_element >= 0) {
            int max_element = arr[0];
            for (int j = 1; j <= last_element; j++) {
                if (arr[j] > max_element) {
                    swap(arr, j);
                    max_element = arr[0];
                }
            }
            swap(arr, last_element);
            last_element--;
        }
    }

    private void swap(int[] arr, int target) {
        int buff = arr[0];
        arr[0] = arr[target];
        arr[target] = buff;
    }
}
