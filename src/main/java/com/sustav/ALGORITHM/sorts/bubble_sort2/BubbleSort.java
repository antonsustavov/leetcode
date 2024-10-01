package com.sustav.ALGORITHM.sorts.bubble_sort2;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
//        System.out.println(Arrays.toString(bubbleSort(array)));
//        System.out.println(Arrays.toString(bubbleSort2(array)));
        System.out.println(Arrays.toString(bubbleSort3(array)));
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    changeValues(array, i, j);
                }
            }
        }
        return array;
    }

    private static void changeValues(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    public static int[] bubbleSort2(int[] array) {
        var isSorted = false;
        var counter = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            counter++;
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    public static int[] bubbleSort3(int[] array) {
        var counter = 0;
        for (int i = 0; i < array.length - counter;) {
            for (int j = i + 1; j < array.length - counter; j++) {
                if (array[i] > array[j]) {
                    changeValues(array, i, j);
                }
                i++;
            }
            i = 0;
            counter++;
        }
        return array;
    }
}
