package com.sustav.ALGORITHM.challenges.algoexpert.medium.longest_peak;

public class LongestPeak {
    // O(n) - time, O(1) - space
    public int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int step = 1;
        while (step < array.length - 1) {
            var isPeak = array[step - 1] < array[step] &&  array[step] > array[step + 1];
            if (!isPeak) {
                step++;
                continue;
            }

            int leftIndex = step - 2;
            while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) leftIndex--;

            int rightIndex = step + 2;
            while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) rightIndex++;

            var currentPeakLength = rightIndex - leftIndex - 1;
            longestPeakLength = Math.max(longestPeakLength, currentPeakLength);

            step = rightIndex;
        }

        return longestPeakLength;
    }
}
