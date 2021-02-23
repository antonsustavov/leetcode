package com.sustav.leetcode.easy.sqrt_x_68;

import java.util.BitSet;

/**
 * @author Anton Sustavov
 * @since 2020/09/25
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.mySqrt(16));
        System.out.println(solution.mySqrt2(2147395600));
        System.out.println(Integer.toBinaryString(2147395600));
        System.out.println(Integer.toBinaryString(46340));
        System.out.println(Integer.toBinaryString(8));
        final BitSet bitSet = solution.fromString(Integer.toBinaryString(2147395600));
        System.out.println(bitSet.toString());
        System.out.println(bitSet.toLongArray()[0]);
    }

    public int mySqrt(int x) {
        int i = 1;
        int result = 1;
        while (true) {
            i = i << 1;
            if (i == x) {
                return i;
            } else if (i > x) {
                return i >> 1;
            }
        }
    }

    private BitSet fromString(String binary) {
        BitSet bitset = new BitSet(binary.length());
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }

    public int mySqrt2(int x) {
        if(x <= 1) return x;
        int start = 1;
        int end = x/2;

        while(start < end) {
            // start is not always moving and hence we can get stuck in infinite loop with mid calculation
            // Adding 1 to mid everytime to ensure we always move the mid
            int mid = (start + (end-start)/2) + 1;

            // use division instead of multiplication to avoid overflow
            int div = x/mid;
            if(div == mid) return mid;
            if(div > mid) start = mid;
            else end = mid-1;
        }

        return start;
    }
}
