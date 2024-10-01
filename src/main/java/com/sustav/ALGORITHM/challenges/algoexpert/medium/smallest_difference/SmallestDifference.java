package com.sustav.ALGORITHM.challenges.algoexpert.medium.smallest_difference;

import java.util.Arrays;

public class SmallestDifference {
    // O(n*log(n)) + O(m*log(m)) - time, O(1) - space
    public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0;
        int idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int[] ints = new int[2];
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int firstNum = arrayOne[idxOne];
            int secondNum = arrayTwo[idxTwo];
            if (firstNum < secondNum) {
                current = secondNum - firstNum;
                idxOne++;
            } else if (secondNum < firstNum) {
                current = firstNum - secondNum;
                idxTwo++;
            } else {
                return new int[]{firstNum, secondNum};
            }
            if (smallest > current) {
                smallest = current;
                ints = new int[]{firstNum, secondNum};
            }
        }
        return ints;
    }

    // O(n*log(n)) + O(m*log(m)) - time, O(1) - space
    public int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0;
        int idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int[] result = new int[]{arrayOne[idxOne], arrayTwo[idxTwo]};
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int diff = Math.abs(arrayOne[idxOne] - arrayTwo[idxTwo]);
            if (diff < smallest) {
                smallest = diff;
                result = new int[]{arrayOne[idxOne], arrayTwo[idxTwo]};
            }

            if (arrayOne[idxOne] < arrayTwo[idxTwo]) {
                idxOne++;
            } else {
                idxTwo++;
            }
        }

        return result;
    }
}
