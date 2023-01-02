package com.sustav.ALGORITHM.challenges.leetcode.easy.reverse_integer_7;

/**
 * @author Anton Sustavov
 * @since 2020/09/15
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(Integer.MIN_VALUE/10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE/10);
        System.out.println(Integer.MAX_VALUE);
        solution.reverse(Integer.MIN_VALUE/10);
        solution.reverse(Integer.MAX_VALUE/10);
        solution.reverse(-123);
        solution.reverse(1534236469);
    }

    public int reverse(int x) {
        int result = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        final String s = String.valueOf(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            final int digit = Character.digit(s.charAt(i), 10);
            if (digit == -1) {
                stringBuilder.insert(0, "-");
            } else {
                stringBuilder.append(digit);
            }
        }
        try {
            result = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e) {
        }

        return result;
    }

    public int reverse2(int x) {
        int reversed = 0;

        while(x != 0) {
            int digit = x % 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return reversed;

    }
}
