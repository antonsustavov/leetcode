package com.sustav.ALGORITHM.challenges.algoexpert.easy.tandem_bicycle;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};
        boolean faster = true;

        System.out.println(tandemBicycle(redShirtSpeeds, blueShirtSpeeds, faster));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        System.out.println(Arrays.toString(redShirtSpeeds));
        System.out.println(Arrays.toString(blueShirtSpeeds));

        if (!fastest) {
            reverseSortInPlace(redShirtSpeeds);
        }

        var totalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            var rider1 = redShirtSpeeds[i];
            var rider2 = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            totalSpeed += Math.max(rider1, rider2);
        }

        return totalSpeed;
    }

    private static void reverseSortInPlace(int[] redShirtSpeeds) {
        var startIdx = 0;
        var endIdx = redShirtSpeeds.length - 1;
        while (startIdx < endIdx) {
            var buffer = redShirtSpeeds[startIdx];
            redShirtSpeeds[startIdx] = redShirtSpeeds[endIdx];
            redShirtSpeeds[endIdx] = buffer;
            startIdx++;
            endIdx--;
        }
    }

}
