package com.sustav.ALGORITHM.challenges.algoexpert.easy.nth_fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Integer, Integer> buffer = new HashMap<>(Map.of(0, 0, 1, 0, 2, 1));

    public static void main(String[] args) {
//        System.out.println(getNthFib(45));
        System.out.println(getNthFib2(50));
        System.out.println(getNthFib3(50));
        System.out.println(getNthFib4(50));
        System.out.println(getNthFib5(50));
    }

    public static int getNthFib(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }

    public static int getNthFib2(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else if (buffer.containsKey(n)) {
            return buffer.get(n);
        } else {
            buffer.put(n, getNthFib2(n - 1) + getNthFib2(n - 2));
        }
        return buffer.get(n);
    }

    public static int getNthFib3(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFib3Mem(n, memoize);
    }

    public static int getNthFib3Mem(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFib3Mem(n - 1, memoize) + getNthFib3Mem(n - 2, memoize));
            return memoize.get(n);
        }
    }

    public static int getNthFib4(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        var counter = 3;
        while (counter <= n) {
            var nextFib = memoize.get(1) + memoize.get(2);
            memoize.put(1, memoize.get(2));
            memoize.put(2, nextFib);
            counter++;
        }
        return memoize.get(2);
    }

    public static int getNthFib5(int n) {
        int[] memoize = {0, 1};
        var counter = 3;
        while (counter <= n) {
            var nextFib = memoize[0] + memoize[1];
            memoize[0] = memoize[1];
            memoize[1] = nextFib;
            counter++;
        }
        return n > 1 ? memoize[1] : memoize[0];
    }
}
