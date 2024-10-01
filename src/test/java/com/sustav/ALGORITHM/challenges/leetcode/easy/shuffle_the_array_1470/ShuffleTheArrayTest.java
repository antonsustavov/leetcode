package com.sustav.ALGORITHM.challenges.leetcode.easy.shuffle_the_array_1470;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShuffleTheArrayTest {
    private ShuffleTheArray shuffleTheArray;

    @BeforeEach
    void setUp() {
        shuffleTheArray = new ShuffleTheArray();
    }

    @Test
    void shuffle() {
        var income = new int[]{2,5,1,3,4,7};
        var halfElement = 3;
        var expected = new int[]{2,3,5,4,1,7};

        int[] actual = shuffleTheArray.shuffle(income, halfElement);

        assertThat(actual).isEqualTo(expected);
    }
}