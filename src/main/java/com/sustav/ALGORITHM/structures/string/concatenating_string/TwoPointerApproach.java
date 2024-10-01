package com.sustav.ALGORITHM.structures.string.concatenating_string;

public class TwoPointerApproach {
    // O(m + n) - time, O(1) - space
    public char[] concatTwoString(char[] str1, char[] str2) {
        char[] result = new char[str1.length + str2.length];
        int resultPointer = 0;
        int pointer = 0;

        while (pointer < str1.length) {
            result[resultPointer] = str1[pointer];
            pointer++;
            resultPointer++;
        }
        pointer = 0;
        while (pointer < str2.length) {
            result[resultPointer] = str2[pointer];
            pointer++;
            resultPointer++;
        }

        return result;
    }
}
