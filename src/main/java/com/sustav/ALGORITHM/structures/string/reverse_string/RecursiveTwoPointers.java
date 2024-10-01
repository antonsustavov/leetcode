package com.sustav.ALGORITHM.structures.string.reverse_string;

public class RecursiveTwoPointers {
    //O(n) - time, O(n) - space
    public char[] reverseStr(String str) {
        char[] chars = str.toCharArray();
        return helperReverse(chars, 0, chars.length - 1);
    }

    private char[] helperReverse(char[] chars, int leftPointer, int rightPointer) {
        if (leftPointer > rightPointer) {
            return chars;
        }

        swap(chars, leftPointer, rightPointer);
        return helperReverse(chars, ++leftPointer, --rightPointer);
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
