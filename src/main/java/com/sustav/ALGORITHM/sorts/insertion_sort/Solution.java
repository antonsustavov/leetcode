package com.sustav.ALGORITHM.sorts.insertion_sort;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(insertionSort3(array)));
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                swap(array, j - 1, j);
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    public static int[] insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j - 1, j);
            }
        }

        return array;
    }

    public static int[] insertionSort3(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j - 1, j);
                j--;
            }
        }

        return array;
    }
}
