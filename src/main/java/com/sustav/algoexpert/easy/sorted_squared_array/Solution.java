package com.sustav.algoexpert.easy.sorted_squared_array;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 8, 9};
        int[] array2 = {-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20};
//        System.out.println(Arrays.toString(sortedSquaredArray(array)));
        System.out.println(Arrays.toString(sortedSquaredArray(array2)));
    }

    public static int[] sortedSquaredArrayOnlogn(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }

        Arrays.sort(result);

        return result;
    }

    public static int[] sortedSquaredArrayOn(int[] array) {
        int[] result = new int[array.length];
        int startPointer = 0;
        int endPointer = array.length - 1;
        int insertPointer = array.length - 1;
        while (startPointer <= endPointer) {
            if (Math.abs(array[startPointer]) > Math.abs(array[endPointer])) {
                result[insertPointer] = array[startPointer] * array[startPointer];
                startPointer++;
            } else {
                result[insertPointer] = array[endPointer] * array[endPointer];
                endPointer--;
            }
            insertPointer--;
        }

        return result;
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int startPointer = 0;
        int endPointer = array.length - 1;
        for(int idx = array.length - 1; idx >= 0; idx--) {
            if (Math.abs(array[startPointer]) > Math.abs(array[endPointer])) {
                result[idx] = array[startPointer] * array[startPointer];
                startPointer++;
            } else {
                result[idx] = array[endPointer] * array[endPointer];
                endPointer--;
            }
        }

        return result;
    }
}
