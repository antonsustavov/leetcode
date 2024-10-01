package com.sustav.ALGORITHM.challenges.algoexpert.easy.insertion_sort;

public class InsertionSort {

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
            var j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap2(array, j - 1, j);
                j--;
            }
        }

        return array;
    }

    private static void swap2(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }
}
