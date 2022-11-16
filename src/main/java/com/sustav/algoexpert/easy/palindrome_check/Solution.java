package com.sustav.algoexpert.easy.palindrome_check;

public class Solution {
    public static void main(String[] args) {
        var str = "abcdcba";
//        var str = "a";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome2(str));
        System.out.println(isPalindromeReverse(str));
        System.out.println(isPalindromeRec(str));
    }

    public static boolean isPalindrome(String str) {
        var leftPointer = 0;
        var rightPointer = str.length() - 1;
        byte[] bytes = str.getBytes();

        while (leftPointer < rightPointer) {
            if (bytes[leftPointer] != bytes[rightPointer]) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    public static boolean isPalindrome2(String str) {
        var leftPointer = 0;
        var rightPointer = str.length() - 1;

        while (leftPointer < rightPointer) {
            if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    public static boolean isPalindromeReverse(String str) {
        StringBuilder reverse = new StringBuilder(str).reverse();

        return str.equals(reverse.toString());
    }

    public static boolean isPalindromeRec(String str) {
        return isPalindromeHelper(str, 0);
    }

    private static boolean isPalindromeHelper(String str, int i) {
        var j = str.length() - i - 1;
        return i >= j || str.charAt(i) == str.charAt(j) && isPalindromeHelper(str, i + 1);
    }
}
