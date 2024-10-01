package com.sustav.ALGORITHM.challenges.algoexpert.easy.balanced_brackets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {

    private BalancedBrackets balancedBrackets;

    @BeforeEach
    void setUp() {
        balancedBrackets = new BalancedBrackets();
    }

    @Test
    public void givenNullInput_whenCheckingForBalance_shouldReturnFalse() {
        var result = balancedBrackets.isBalanced("({[]})");
        assertThat(result).isTrue();
    }

    @Test
    void isBalanced() {
    }

    @Test
    void isBalanced2() {
    }
}