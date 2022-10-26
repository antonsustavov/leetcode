package com.sustav.algoexpert.easy.valid_subseq;

import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10);
        System.out.println(isValidSubsequenceOn_1(array, sequence));
        System.out.println(isValidSubsequenceOn_2(array, sequence));
        System.out.println(isValidSubsequenceOn_3(array, sequence));
        System.out.println(isValidSubsequenceOn_4(array, sequence));
    }

    public static boolean isValidSubsequenceOn_1(List<Integer> array, List<Integer> sequence) {
        int pointer = 0;
        int sequenceSize = sequence.size();
        for (Integer value: array) {
            if (pointer == sequenceSize) {
                break;
            }
            if (sequence.get(pointer).equals(value)) {
                pointer++;
            }
        }

        return pointer == sequenceSize;
    }

    public static boolean isValidSubsequenceOn_2(List<Integer> array, List<Integer> sequence) {
        int sequenceCounter = sequence.size();
        int pointer = 0;
        for (Integer currentNum: array) {
            if (currentNum.equals(sequence.get(pointer))) {
                pointer++;
                sequenceCounter--;
            }
            if (sequenceCounter == 0) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidSubsequenceOn_3(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (Objects.equals(array.get(arrIdx), sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }

        return seqIdx == sequence.size();
    }

    public static boolean isValidSubsequenceOn_4(List<Integer> array, List<Integer> sequence) {
        if (sequence.size() == 0) {
            return true;
        }

        if (array.contains(sequence.get(0))) {
            return isValidSubsequenceOn_4(array.subList(array.indexOf(sequence.get(0)) + 1, array.size()), sequence.subList(1, sequence.size()));
        }

        return false;
    }
}
