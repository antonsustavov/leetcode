package com.sustav.algoexpert.easy.class_photos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static final String RED = "RED";
    private static final String BLUE = "BLUE";

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>(List.of(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(List.of(6, 9, 2, 4, 5));

        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        ArrayList<Integer> hairRow = null;
        ArrayList<Integer> lessRow = null;
        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            hairRow = redShirtHeights;
            lessRow = blueShirtHeights;
        } else if (redShirtHeights.get(0) < blueShirtHeights.get(0)) {
            hairRow = blueShirtHeights;
            lessRow = redShirtHeights;
        } else {
            return false;
        }

        for (int i = 0; i < hairRow.size(); i++) {
            if (hairRow.get(i) < lessRow.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean classPhotos2(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        var diff = redShirtHeights.get(0) - blueShirtHeights.get(0);

        for (int i = 0; i < redShirtHeights.size(); i++) {
            if ((redShirtHeights.get(i) - blueShirtHeights.get(i)) * diff <= 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean classPhotos3(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        var shitColorInFirstRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? RED : BLUE;

        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (RED.equals(shitColorInFirstRow)) {
                if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
