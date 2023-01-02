package com.sustav.ALGORITHM.challenges.leetcode.algorithm.quick_sort;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Anton Sustavov
 * @since 2020/10/07
 */
public class QuickSort {
    public static void main(String[] args) {
        String str = "Charlie Jennifer Charlie Bob Charlie Charlie Bob Jennifer Alice Alice";
        final String[] s = str.split(" ");
        final Map<String, Long> collect = Arrays.stream(s)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        Arrays.stream(s)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(ints));
        quickSort.quickSort(ints, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
//        int pivot = arr[(int)(Math.random() * (end - start + 1) + start)];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);

        return pIndex;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
