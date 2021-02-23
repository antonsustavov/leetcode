package com.sustav.leetcode.easy.plus_one_66;

import java.util.Arrays;

/**
 * @author Anton Sustavov
 * @since 2020/09/24
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int pointer = digits.length - 1;
        do {
            carry = (digits[pointer] + 1) / 10;
            digits[pointer] = carry > 0 ? 0 : digits[pointer] + 1;
            pointer--;
            if (pointer < 0 && carry > 0) {
                int[] buffer = new int[digits.length+1];
                for (int i = 0; i < digits.length; i++) {
                    buffer[i+1] = digits[i];
                }
                digits = buffer;
                pointer = 0;
            }
        } while (carry > 0);

        return digits;
    }
}
