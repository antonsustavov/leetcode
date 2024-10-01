package com.sustav.ALGORITHM.challenges.leetcode.easy.reverse_string_344;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length == 1) {
            System.out.println(s);
            return;
        }
        var leftPointer = 0;
        var rightPointer = s.length - 1;
        while (leftPointer < rightPointer) {
            var temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        System.out.println(s);
    }
}
