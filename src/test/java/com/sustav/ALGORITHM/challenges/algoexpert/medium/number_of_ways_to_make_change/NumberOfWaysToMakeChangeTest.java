package com.sustav.ALGORITHM.challenges.algoexpert.medium.number_of_ways_to_make_change;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

class NumberOfWaysToMakeChangeTest {
    private NumberOfWaysToMakeChange numberOfWaysToMakeChange;

    @BeforeEach
    void setUp() {
        numberOfWaysToMakeChange = new NumberOfWaysToMakeChange();
    }

    @Test
    void numberOfWaysToMakeChange() {
        int[] ways = IntStream.rangeClosed(0, 6 + 1).toArray();
        System.out.println(Arrays.toString(ways));
    }
}