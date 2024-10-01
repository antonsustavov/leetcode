package com.sustav.ALGORITHM.structures.string.reverse_string;

public class FromLastToFirstLoop {
    //O(n^2) - time, O(1) - space
    public char[] reverseStr(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int leftPointer = 0;
        int rightPointer = length - 1;

//        for (; rightPointer > leftPointer; ) {
//            for (int j = rightPointer; j > leftPointer; j--) {
//                swap(chars, j, j - 1);
//            }
//            leftPointer++;
//        }

        while (rightPointer > leftPointer) {
            for (int j = rightPointer; j > leftPointer; j--) {
                swap(chars, j, j - 1);
            }
            leftPointer++;
        }

        return chars;
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
