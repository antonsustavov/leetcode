package com.sustav.ALGORITHM.challenges.algoexpert.easy.swap_letter_string;

public class SwapLetterStringInPlace {
    // O(n^2) - time, O(1) - space
    // abc1234 , index 3 -> 1234abc
    // ab1, 2 -> 1ab
    public char[] swapString(char[] income, Integer idx) {
        if (idx > income.length || idx <= 0) {
            return income;
        }

        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < income.length - 1; j++) {
                swap(income, j, j + 1);
            }
        }

        return income;
    }

    private void swap(char[] income, int leftPointer, int rightPointer) {
        var temp = income[leftPointer];
        income[leftPointer] = income[rightPointer];
        income[rightPointer] = temp;
    }
}
