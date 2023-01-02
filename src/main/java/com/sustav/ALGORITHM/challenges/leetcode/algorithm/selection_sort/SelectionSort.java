package com.sustav.ALGORITHM.challenges.leetcode.algorithm.selection_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/10/07
 */
public class SelectionSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(ints));
        selectionSort.selectionSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void selectionSort(int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            int indexMin = i;
            for (int j = i+1; j < length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            swap(arr, i, indexMin);
        }

    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
