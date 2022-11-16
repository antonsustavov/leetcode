package com.sustav.algoexpert.easy.find_three_lagest_numbers;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(Arrays.toString(findThreeLargestNumbers(array)));
        System.out.println(Arrays.toString(findThreeLargestNumbers2(array)));
        System.out.println(Arrays.toString(findThreeLargestNumbers3(array)));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] ints = Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(ints);

        return ints;
    }

    public static int[] findThreeLargestNumbers2(int[] array) {
        int[] result = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        System.out.println(Arrays.toString(result));
        for (int num : array) {
            if (num > result[2]) {
                result[0] = result[1];
                result[1] = result[2];
                result[2] = num;
            } else if (num > result[1]) {
                result[0] = result[1];
                result[1] = num;
            } else if (num > result[0]) {
                result[0] = num;
            }
        }

        return result;
    }

    public static int[] findThreeLargestNumbers3(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(threeLargest, num);
        }

        return threeLargest;
    }

    private static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] threeLargest, int num, int idx) {
        for (int i = 0; i < idx + 1; i++) {
            if (i == idx) {
                threeLargest[i] = num;
            } else {
                threeLargest[i] = threeLargest[i + 1];
            }
        }
    }
}
