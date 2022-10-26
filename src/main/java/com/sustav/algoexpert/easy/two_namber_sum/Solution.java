package com.sustav.algoexpert.easy.two_namber_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 5, -4, 8, 11, 1, -1, 6);
        int[] intArray = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.stream(twoNumberSumOn2(integers.stream().toArray(Integer[]::new), 10)).toArray());
        System.out.println(Arrays.toString(twoNumberSumOnLogN(intArray, 10)));
        System.out.println(Arrays.toString(twoNumberSumOn(intArray, 10)));
    }

    public static int[] twoNumberSumOn2(Integer[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if (array[i] + array[j] == targetSum) {
                    return new int[]{firstNum, secondNum};
                }
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSumOnLogN(int[] array, int targetSum) {
        if (array.length == 0) return new int[0];

        Arrays.sort(array); //(nlogn)

        int leftPointer = 0;
        int rightPointer = array.length - 1;

        for (int i = leftPointer; i < rightPointer; ) {
            int sum = array[i] + array[rightPointer];
            if (sum == targetSum) {
                return new int[]{array[i], array[rightPointer]};
            } else if (sum < targetSum) {
                i++;
            } else {
                rightPointer--;
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSumOnLogN2(int[] array, int targetSum) {
        if (array.length == 0) return new int[0];

        Arrays.sort(array); //(nlogn)

        int leftPointer = 0;
        int rightPointer = array.length - 1;

        while (leftPointer < rightPointer) {
            int sum = array[leftPointer] + array[rightPointer];
            if (sum == targetSum) {
                return new int[]{array[leftPointer], array[rightPointer]};
            } else if (sum < targetSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[0];
    }

    public static int[] twoNumberSumOn(int[] array, int targetSum) {
        HashSet<Integer> buffer = new HashSet<>();
        for (int currentNum : array) {
            int targetValue = targetSum - currentNum;
            if (buffer.contains(targetValue)) {
                return new int[]{targetValue, currentNum};
            } else {
                buffer.add(currentNum);
            }
        }
        return new int[0];
    }
}
