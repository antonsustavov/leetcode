package com.sustav.ALGORITHM.challenges.algoexpert.medium.spiral_traverse;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] givenArray = {
                {1, 2, 3, 4, 0},
                {12, 13, 14, 5, 0},
                {11, 16, 15, 6, 0},
                {10, 9, 8, 7, 0}
        };
        int[][] givenArray2 = {
                {1, 2, 3, 4, 5, 6}
        };
        spiralTraverse(givenArray2);
        spiralTraverseRecursive(givenArray2);
    }

    public static List<Integer> spiralTraverseRecursive(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;
        spiralFill(array, startRow, endRow, startColumn, endColumn, result);
        System.out.println(result);
        return result;
    }

    private static void spiralFill(int[][] array, int startRow, int endRow, int startColumn, int endColumn, List<Integer> result) {
        if (startRow > endRow || startColumn > endColumn) return;

        for (int i = startColumn; i <= endColumn; i++) {
            result.add(array[startRow][i]);
        }
        startRow++;

        for (int i = startRow; i <= endRow + 1; i++) {
            result.add(array[i][endColumn]);
        }
        endColumn--;

        for (int i = endColumn; i >= startColumn; i--) {
            result.add(array[endRow][i]);
        }
        endRow--;

        for (int i = endRow; i >= startRow; i--) {
            result.add(array[i][startColumn]);
        }
        startColumn++;

        spiralFill(array, startRow, endRow, startColumn, endColumn, result);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;
        while (startRow <= endRow && startColumn <= endColumn) {
            if (startColumn <= endColumn) {
                for (int i = startColumn; i <= endColumn; i++) {
                    result.add(array[startRow][i]);
                }
                startRow++;
            } else break;

            if (startRow <= endRow) {
                for (int i = startRow; i <= endRow; i++) {
                    result.add(array[i][endColumn]);
                }
                endColumn--;
            } else break;

            if (endColumn >= startColumn) {
                for (int i = endColumn; i >= startColumn; i--) {
                    result.add(array[endRow][i]);
                }
                endRow--;
            } else break;

            if (endRow >= startRow) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(array[i][startColumn]);
                }
                startColumn++;
            } else break;

        }
        System.out.println(result);
        return result;
    }
}
