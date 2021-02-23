package com.sustav.leetcode.algorithm.heap_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/12/02
 */
public class HeapSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(ints));
        heapSort.makePyramid(ints);
        System.out.println(Arrays.toString(ints));
        heapSort.heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private void heapSort(int[] ints) {
        for (int i = ints.length - 1; i >= 0 ; i--) {
            swap(ints, 0, i);
            down(ints, i, 0);
        }
    }

    public void makePyramid(int[] arr) {
        for (int i = arr.length/2 -1; i >= 0 ; i--) {
            down(arr, arr.length, i);
        }
    }

    private void down(int[] arr, int size, int root) {
        int left = 2 * root + 1;
        int right = left + 1;
        int max = root;
        if (left < size && arr[left] > arr[max]) max = left;
        if (right < size && arr[right] > arr[max]) max = right;
        if (max == root) return;
        swap(arr, root, max);
        down(arr, size, max);
    }

    private void swap(int[] arr, int from, int to) {
        int buff = arr[to];
        arr[to] = arr[from];
        arr[from] = buff;
    }
}
