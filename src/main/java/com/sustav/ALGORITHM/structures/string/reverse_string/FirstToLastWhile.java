package com.sustav.ALGORITHM.structures.string.reverse_string;

public class FirstToLastWhile {
    //O(n) - time, O(1) - space
    public char[] reverseStr(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int leftPointer = 0;
        int rightPointer = length - 1;
        int operationCounter = 0;

        while (leftPointer < rightPointer) {
            swap(chars, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
            operationCounter++;
        }

        System.out.println("Length of string: " + length + " operations: " + operationCounter);
        return chars;
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
