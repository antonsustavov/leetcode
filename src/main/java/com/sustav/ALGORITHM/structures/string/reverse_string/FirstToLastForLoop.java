package com.sustav.ALGORITHM.structures.string.reverse_string;

public class FirstToLastForLoop {
    //O(n) - time, O(1) - space
    public char[] reverseStr(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;

        // Swap character starting from two
        // corners
        for (int i = 0; i < length / 2; i++) {
            swap(chars, i, length - i - 1);
        }

        return chars;
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
