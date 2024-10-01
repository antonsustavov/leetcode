package com.sustav.ALGORITHM.challenges.leetcode.algorithm.merge_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/10/04
 */
public class MergeSort2 {
    public static void main(String[] args) {
        final MergeSort2 mergeSort2 = new MergeSort2();
        final int[] ints = new Random().ints(20, 0, 34).toArray();
        System.out.println(Arrays.toString(ints));
        mergeSort2.mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];
        for (int i = 0; i < mid-1; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length-1; i++) {
            left[i-mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int nL = left.length;
        int nR = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
