package com.sustav.ALGORITHM.challenges.algoexpert.medium.levenshtein_distance;

public class LevenshteinDistance {
    public int levenshteinDistance(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str2.length() + 1; i++) {
            matrix[0][i] = i;
        }
        for (int i = 0; i < str1.length() + 1; i++) {
            matrix[i][0] = i;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str2.charAt(j - 1) == str1.charAt(i - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
                }
            }
        }

        return matrix[str1.length()][str2.length()];
    }
}
