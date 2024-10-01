package com.sustav.ALGORITHM.structures.string.concatenating_string;

import java.util.Arrays;

public class ConcatRecursion {
    // O(m) - time, O(m+n) - space
    public char[] concatTwoString(char[] str1, char[] str2) {
        int pointer = 0;
        int len = str1.length;
        str1 = Arrays.copyOf(str1, str1.length + str2.length);
        concatTwoStringHelper(str1, str2, pointer, len);

        return str1;

    }

    private void concatTwoStringHelper(char[] str1, char[] str2, int pointer, int len) {
        if (pointer < str2.length) {
            str1[pointer + len] = str2[pointer];
            pointer++;
            concatTwoStringHelper(str1, str2, pointer, len);
        }
    }
}
