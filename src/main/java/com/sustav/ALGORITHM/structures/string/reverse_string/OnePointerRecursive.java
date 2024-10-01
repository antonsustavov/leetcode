package com.sustav.ALGORITHM.structures.string.reverse_string;

public class OnePointerRecursive {
    //O(n) - time, O(n) - space
    public void reverseStr(char[] str) {
        helperReverse(str, 0);
    }

    private void helperReverse(char[] str, int i) {
        if (i > str.length - i - 1) {
            return;
        }
        swap(str, i, str.length - i - 1);
        i++;
        helperReverse(str, i);
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
