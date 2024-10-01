package com.sustav.ALGORITHM.challenges.algoexpert.medium.first_duplicate_value;

import java.util.BitSet;

public class FirstDuplicateValue {
    // O(n^2) - time, O(1) - space
    public int firstDuplicateValue(int[] array) {
        int index = array.length;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    index = Math.min(j, index);
                }
            }
        }

        return index == array.length ? -1 : array[index];
    }

    // O(n) - time, O(n) - space
    public int firstDuplicateValueBitSet(int[] array) {
        int index = array.length;
        BitSet bitSet = new BitSet(array.length);

        for (int i = 0; i < array.length; i++) {
            boolean isPresent = bitSet.get(array[i]);
            if (isPresent) {
                return array[i];
            } else bitSet.set(array[i]);
        }

        return -1;
    }

    // O(n) - time, O(n) - space
    public int firstDuplicateValueAbs(int[] array) {

        for (int i = 0; i < array.length; i++) {
            var absValue = Math.abs(array[i]);
            if (array[absValue - 1] < 0) {
                return absValue;
            } else {
                array[absValue - 1] *= -1;
            }
        }

        return -1;
    }

}
