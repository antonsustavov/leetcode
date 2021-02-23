package com.sustav.leetcode.algorithm.bubble_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Anton Sustavov
 * @since 2020/10/07
 */
public class BubbleSort {
    public static void main(String[] args) {
        final int[] ints = new Random().ints(20, 0, 20).toArray();
        final BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(ints));
        bubbleSort.bubbleSort(ints);
        System.out.println(Arrays.toString(ints));

        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(Arrays.asList(1, 2, 3, 4));
        group.add(Arrays.asList(5, 6, 7, 8));
        group.add(Arrays.asList(9, 10, 11, 12));
        ArrayList<ArrayList<Integer>> B = bubbleSort.performOps(group);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    ArrayList<ArrayList<Integer>> performOps(ArrayList<List<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}
