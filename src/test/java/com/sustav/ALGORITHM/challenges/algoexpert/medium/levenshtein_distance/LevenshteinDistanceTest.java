package com.sustav.ALGORITHM.challenges.algoexpert.medium.levenshtein_distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LevenshteinDistanceTest {
    private LevenshteinDistance levenshteinDistance;

    @BeforeEach
    void setUp() {
        levenshteinDistance = new LevenshteinDistance();
    }

    @Test
    void levenshteinDistance() {
        var given1 = "abc";
        var given2 = "yabd";
        var expected = 2;

        int actual = levenshteinDistance.levenshteinDistance(given1, given2);

        assertThat(actual).isEqualTo(2);
    }
}