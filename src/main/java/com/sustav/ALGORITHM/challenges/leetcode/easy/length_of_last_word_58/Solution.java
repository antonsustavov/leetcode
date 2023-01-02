package com.sustav.ALGORITHM.challenges.leetcode.easy.length_of_last_word_58;

/**
 * @author Anton Sustavov
 * @since 2020/09/24
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord2(" a"));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        int lastChar = s.length()-1;
        while (lastChar >= 0) {
            if (s.charAt(lastChar) == ' ' && result != 0) {
                return result;
            } else if (s.charAt(lastChar) != ' ') {
                result++;
            }
            lastChar--;
        }

        return result;
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        final String trim = s.trim();
        int lastChar = trim.length()-1;
        while (lastChar >= 0) {
            if (trim.charAt(lastChar) == ' ') {
                return result;
            }
            result++;
            lastChar--;
        }

        return result;
    }
}
