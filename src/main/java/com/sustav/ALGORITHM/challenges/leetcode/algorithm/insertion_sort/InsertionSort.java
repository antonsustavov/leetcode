package com.sustav.ALGORITHM.challenges.leetcode.algorithm.insertion_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/10/04
 */
public class InsertionSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(ints));
        insertionSort.insertionSort(ints);
        System.out.println(Arrays.toString(ints));

    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int pointer = i;
            while (pointer > 0 && arr[pointer-1] > value) {
                arr[pointer] = arr[pointer-1];
                pointer--;
            }
            arr[pointer] = value;
        }
    }
}
