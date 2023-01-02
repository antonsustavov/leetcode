package com.sustav.ALGORITHM.challenges.leetcode.algorithm.merge_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/10/04
 */
public class MergeSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(ints));
        mergeSort.mergeSort(ints, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

//        while (i <= mid && j <= end) {
//            if (arr[i] <= arr[j]) {
//                arr[k] = arr[i];
//                i++;
//            } else {
//                arr[k] = arr[j];
//                j++;
//            }
//            k++;
//        }
//
//        while (i <= mid) {
//            arr[k] = arr[i];
//            i++;
//            k++;
//        }
//
//        while (j <= end) {
//            arr[k] = arr[j];
//            j++;
//            k++;
//        }

//        with temp arr
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
//        for (int l = start; l <= end; l++) {
//            arr[l] = temp[l-start];
//        }

    }
}
