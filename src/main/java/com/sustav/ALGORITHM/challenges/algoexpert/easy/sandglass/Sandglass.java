package com.sustav.ALGORITHM.challenges.algoexpert.easy.sandglass;

import java.util.Scanner;

public class Sandglass {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int fullTimeCircleInMinutes = 0;
    int passedTimeInMinutes = 0;
    int rows = 0;
    int cols = 0;

    while (true) {
      System.out.print("Enter rows: ");
      rows = scanner.nextInt();
      System.out.print("Enter calls: ");
      cols = scanner.nextInt();
      System.out.print("Enter full time circle in minutes: ");
      fullTimeCircleInMinutes = scanner.nextInt();
      System.out.print("Enter passed time in minutes: ");
      passedTimeInMinutes = scanner.nextInt();

      if (passedTimeInMinutes > fullTimeCircleInMinutes) {
        System.out.println("Passed time cannot be greater than full time circle. Please enter again.");
      } else {
        break;
      }
    }

    String[][] sandGlass = new String[rows][cols];
    populateMatrix(sandGlass);
    double rowStep = (double) rows / cols;

    int remainingTime = fullTimeCircleInMinutes - passedTimeInMinutes;
    int countRowsUp = remainingTime * cols / fullTimeCircleInMinutes;
    int countRowsDown = passedTimeInMinutes * cols / fullTimeCircleInMinutes;

    int startRow = cols - countRowsUp;
    int endRow = (int)(rows - countRowsDown - rowStep);
    for (int col = 0; col < cols; col++) {
      int row = (int) Math.round(col * rowStep);
      if (row < rows) {
        sandGlass[row][col] = "*";
        sandGlass[row][cols - col - 1] = "*";
        if (row >= startRow) {
          for (int i = col + 1; i <= cols - col - 2; i++) {
            sandGlass[row][i] = " * ";
          }
        }
        if (row >= endRow) {
          for (int i = col - 1; i > cols - col - 1; i--) {
            sandGlass[row][i] = " * ";
          }
        }
      }
    }

    printSandglass(sandGlass, cols);
  }

  private static void populateMatrix(String[][] sandGlass) {
    for (int i = 0; i < sandGlass.length; i++) {
      for (int j = 0; j < sandGlass[i].length; j++) {
        sandGlass[i][j] = "   ";
      }
    }
  }

  private static void printSandglass(String[][] sandGlass, int cols) {
    for (String[] glass : sandGlass) {
      for (int j = 0; j < cols; j++) {
        System.out.print(glass[j]);
      }
      System.out.println("");
    }
  }
}
