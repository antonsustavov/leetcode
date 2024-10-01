package com.sustav.ALGORITHM.challenges.algoexpert.easy.selection_sort;

public class SelectionSort {
    public static void main(String[] args) {
        String aaa = "abc";
        String aaa2 = new String("abc");
        System.out.println(aaa == aaa2);
        System.out.println(aaa.equals(aaa2));
        System.out.println(EnumStr.AAA.equals("abc"));
//        System.out.println(EnumStr.AAA == "abc");
        EnumStr aaa1 = EnumStr.valueOf("AAA");
        EnumStr aaa3 = EnumStr.valueOf("AAA2");
        System.out.println(aaa1.equals(aaa3));
        System.out.println(aaa1 == aaa3);
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, min, i);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    public static int[] selectionSort2(int[] array) {
        var currentIdx = 0;
        while (currentIdx < array.length - 1) {
            var smallestIdx = currentIdx;
            for (int i = currentIdx + 1; i < array.length; i++) {
                if (array[i] < array[smallestIdx]) {
                    smallestIdx = i;
                }
            }
            swap2(array, smallestIdx, currentIdx);
            currentIdx++;
        }

        return array;
    }

    private static void swap2(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }
}
