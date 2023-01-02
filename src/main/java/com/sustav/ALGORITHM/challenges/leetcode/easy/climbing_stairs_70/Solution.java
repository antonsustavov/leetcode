package com.sustav.ALGORITHM.challenges.leetcode.easy.climbing_stairs_70;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Sustavov
 * @since 2020/09/25
 */
public class Solution {
    private Map<Integer, Integer> buffer = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.climbStairs(44));
    }

    public int climbStairs(int n) {
        return climbSteps(0, n);
    }

    private int climbSteps(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        int firstStep = i + 1;
        int secondStep = i + 2;
        int r;
        if (buffer.containsKey(firstStep + secondStep)) {
            return buffer.get(firstStep + secondStep);
        } else {
            r = climbSteps(firstStep, n) + climbSteps(secondStep, n);
            buffer.put(firstStep+secondStep, r);
        }
        return r;

    }
}
