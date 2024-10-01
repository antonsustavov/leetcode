package com.sustav.ALGORITHM.challenges.algoexpert.medium.merge_overlapping_intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeOverlappingIntervalsTest {
    private MergeOverlappingIntervals mergeOverlappingIntervals;

    @BeforeEach
    void setUp() {
        mergeOverlappingIntervals = new MergeOverlappingIntervals();
    }

    @Test
    void mergeOverlappingIntervals() {
        int[][] given = { {1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10} };
        int[][] expected = { {1, 2}, {3, 8}, {9, 10} };

       var actual = mergeOverlappingIntervals.mergeOverlappingIntervals(given);

        assertThat(actual).isEqualTo(expected);
    }
}