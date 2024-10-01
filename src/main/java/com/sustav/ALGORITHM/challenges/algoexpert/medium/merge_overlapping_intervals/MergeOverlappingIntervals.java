package com.sustav.ALGORITHM.challenges.algoexpert.medium.merge_overlapping_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    // O(nlogn) - time, O(n) - space
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        
        List<int[]> mergedInterval = new ArrayList<>();
        var currentInterval = intervals[0];
        mergedInterval.add(intervals[0]);

        for (int[] nextInterval : intervals) {
            var currentIntervalEnd = currentInterval[1];
            var nextIntervalStart = nextInterval[0];
            var nextIntervalEnd = nextInterval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedInterval.add(currentInterval);
            }
        }

        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}
