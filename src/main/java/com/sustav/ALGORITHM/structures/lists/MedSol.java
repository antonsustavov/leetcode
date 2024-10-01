package com.sustav.ALGORITHM.structures.lists;

import com.google.common.math.Quantiles;

import java.math.RoundingMode;
import java.util.List;

import static java.lang.Math.pow;
import static java.math.BigDecimal.valueOf;

public class MedSol {
    public static void main(String[] args) {
//        List<Integer> rssi = List.of(-65, -65, -64, -64, -60, -59);
//        List<Integer> rssi = List.of(-63, -60, -59, -59, -59, -58);
//        List<Integer> rssi = List.of(-59, -59, -64, -64, -64, -64);
//        List<Integer> rssi = List.of(-64, -64, -64, -64, -63, -60);
        List<Integer> rssi = List.of(-59, -65, -64, -64, -65, -65);
        System.out.println(calculateDistance(rssi));
    }

    public static Double calculateDistance(List<Integer> rssis) {
        double median = calculateMedian(rssis);
        double value = pow(10, ((-41 - median) / (10 * 4)));
        return valueOf(value).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private static double calculateMedian(List<Integer> rssis) {
        return Quantiles.median().compute(rssis);
    }
}
