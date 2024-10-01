package com.sustav.ALGORITHM.challenges.algoexpert.medium.best_seat;

public class BestSeat {

    // O(n) - time; O(n) - space
    public int bestSeat(int[] seats) {
        var bestSeat = -1;
        var maxSpace = 0;

        var leftPointer = 0;

        while (leftPointer < seats.length) {
            var rightPointer = leftPointer + 1;
            while (rightPointer < seats.length && seats[rightPointer] == 0) {
                rightPointer++;
            }

            var availableSpace = rightPointer - leftPointer - 1;
            if (availableSpace > maxSpace) {
                bestSeat = (rightPointer + leftPointer) / 2;
                maxSpace = availableSpace;
            }
            leftPointer = rightPointer;
        }


        return bestSeat;
    }

}
