package com.sustav.ALGORITHM.sorts.selection_sort;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(selectionSort2(array)));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, min, i);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    public static int[] selectionSort2(int[] array) {
        var currentIdx = 0;
        while (currentIdx < array.length - 1) {
            var smallestIdx = currentIdx;
            for (int i = currentIdx + 1; i < array.length; i++) {
                if (array[i] < array[smallestIdx]) {
                    smallestIdx = i;
                }
            }
            swap(array, smallestIdx, currentIdx);
            currentIdx++;
        }

        return array;
    }
}
