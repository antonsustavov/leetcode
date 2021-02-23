package com.sustav.leetcode.easy.add_binary_67;

import java.util.BitSet;

/**
 * @author Anton Sustavov
 * @since 2020/09/25
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("1", "111"));
    }

    public String addBinary(String a, String b) {
        if(a.length() == 0)
            return b;
        if(b.length() == 0)
            return a;
        final StringBuilder result = new StringBuilder();
        int pointerA = a.length()-1;
        int pointerB = b.length()-1;
        int carry = 0;

        while (pointerA >= 0 || pointerB >= 0 || carry > 0) {
            int numberA = pointerA < 0 ? 0 : (int) a.charAt(pointerA) - 48;
            int numberB = pointerB < 0 ? 0 : (int) b.charAt(pointerB) - 48;
//            result.append(Math.abs(Math.abs(numberA-numberB) - carry));
            result.insert(0, Math.abs(Math.abs(numberA-numberB) - carry));
            carry = (numberA + numberB + carry) / 2;
            pointerA--;
            pointerB--;
        }
//        return result.reverse().toString();
        return result.toString();

    }

    public String addBinary2(String a, String b) {
        final BitSet bitSet = new BitSet();

        return "";
    }
}
