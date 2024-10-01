package com.sustav.ALGORITHM.challenges.algoexpert.easy.transpose_matrix;

import java.util.Arrays;

public class TransposeMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int[][] matrix2 = {
        {1, 2}
    };

    int[][] matrix3 = {
        {1, 2},
        {3, 4},
        {5, 6}
    };

    System.out.println(Arrays.deepToString(transposeMatrix(matrix3)));
  }

  public static int[][] transposeMatrix(final int[][] matrix) {
    int columns = matrix[0].length;
    int rows = matrix.length;

    int[][] newMatrix = new int[columns][rows];

    for (int column = 0; column < columns; column++) {
      for (int row = 0; row < rows; row++) {
        newMatrix[column][row] = matrix[row][column];
      }
    }

    return newMatrix;
  }

}

/*
actual:
[1, 2]
[3, 4]
[5, 6]

expected:
[1, 3, 5]
[2, 4, 6]
 */