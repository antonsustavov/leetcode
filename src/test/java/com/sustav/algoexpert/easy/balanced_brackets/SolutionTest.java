package com.sustav.algoexpert.easy.balanced_brackets;

import com.sustav.ALGORITHM.challenges.algoexpert.easy.balanced_brackets.Solution;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void givenNullInput_whenCheckingForBalance_shouldReturnFalse() {
        var result = solution.isBalanced("({[]})");
        assertThat(result).isTrue();
    }

}