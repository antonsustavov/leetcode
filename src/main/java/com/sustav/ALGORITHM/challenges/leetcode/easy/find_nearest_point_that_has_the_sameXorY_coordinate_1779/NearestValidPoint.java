package com.sustav.ALGORITHM.challenges.leetcode.easy.find_nearest_point_that_has_the_sameXorY_coordinate_1779;

public class NearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int sIndex = 100000;
        int sDistance = 100000;

        for (int i = 0; i < points.length; i++) {

            // Check if is a valid point
            if (points[i][0] == x || points[i][1] == y) {

                // Check if it is better than the previous best
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (sDistance > distance) {
                    sDistance = distance;
                    sIndex = i;
                }
            }
        }

        // Check if we have a valid point to return
        if (sIndex == 100000)
            return -1;
        return sIndex;
    }
}
