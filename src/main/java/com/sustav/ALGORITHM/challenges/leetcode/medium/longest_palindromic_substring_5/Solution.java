package com.sustav.ALGORITHM.challenges.leetcode.medium.longest_palindromic_substring_5;

/**
 * @author Anton Sustavov
 * @since 2020/09/15
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2("babad"));
        System.out.println(solution.longestPalindrome2("cbbd"));
        System.out.println(solution.longestPalindrome2("adam"));
        System.out.println(solution.longestPalindrome2("ac"));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return String.valueOf(s.charAt(0));
        }
        final StringBuilder stringBuilderLeft = new StringBuilder();
        final StringBuilder stringBuilderRight = new StringBuilder();
        int left = 0;
        int right = s.length()-1;
        while (left <= right) {
            if (left == right && stringBuilderLeft.length() != 0) {
                stringBuilderLeft.append(s.charAt(left));
            } else if (s.charAt(left) == s.charAt(right)) {
                stringBuilderLeft.append(s.charAt(left));
                stringBuilderRight.append(s.charAt(right));
            } else {
            }
            left++;
            right--;
        }
        stringBuilderLeft.append(stringBuilderRight);

        return stringBuilderLeft.toString();
    }

    public String longestPalindrome2(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String current;
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            current = checkSubString(s, 0, i);
            if (current.length() > result.length()) {
                result = current;
            }
        }

        return result;
    }

    private String checkSubString(String s, int left, int right) {
        final StringBuilder stringBuilderLeft = new StringBuilder();
        final StringBuilder stringBuilderRight = new StringBuilder();
        while (left <= right) {
            if (left == right && stringBuilderLeft.length() != 0) {
                stringBuilderLeft.append(s.charAt(left));
            } else if (s.charAt(left) == s.charAt(right)) {
                stringBuilderLeft.append(s.charAt(left));
                if (left != right) {
                    stringBuilderRight.append(s.charAt(right));
                }
            }
            left++;
            right--;
        }
        stringBuilderLeft.append(stringBuilderRight);

        return stringBuilderLeft.toString();
    }
}
