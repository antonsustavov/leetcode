package com.sustav.ALGORITHM.challenges.algoexpert.easy.product_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(5);
        objects.add(2);
        objects.add(List.of(7, -1));
        objects.add(3);
        objects.add(List.of(6, List.of(-13, 8), 4));

        System.out.println(productSum(objects));
//        System.out.println(productSum2(objects));
    }

    public static int productSum(List<Object> array) {
        return productSum(array,1);
    }

    public static int productSumRecursive(List<?> array, int sum, int level) {
        for (int i = 0; i < array.size(); i++) {
            Object element = array.get(i);
            if (element instanceof List<?>) {
//                level *= level + 1;
                sum += level * productSumRecursive((List<?>) element, 0, level + 1);
//                level /= level + 1;
            } else {
                sum += (Integer) element;
            }
        }

        return sum;
    }

    public static int productSum2(List<Object> array) {
        var sum = 0;
        var idx = 0;
        var level = 1;
        var currentArray = array;
        while (idx < currentArray.size()) {
           if (currentArray.get(idx) instanceof List<?>) {
               currentArray = (List<Object>) currentArray.get(idx);
               idx = 0;
               level += 1;
           } else {
               sum += (Integer) currentArray.get(idx) * level;
               idx++;
           }
        }
        return sum;
    }

    public static int productSumRecursive3(List<?> array, int multiplier) {
        int sum = 0;
        for (Object element: array) {
            if (element instanceof List<?>) {
                sum += productSumRecursive3((List<?>) element, multiplier + 1);
            } else {
                sum += (Integer) element;
            }
        }

        return sum * multiplier;
    }

    public static int productSum(List<?> array, int multiplier) {
        int sum = 0;
        for (Object element: array) {
            if (element instanceof List<?>) {
                sum += productSum((List<?>) element, multiplier + 1);
            } else {
                sum += (Integer) element;
            }
        }

        return sum * multiplier;
    }
}
