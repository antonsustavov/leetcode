package com.sustav.ALGORITHM.challenges.leetcode.medium.spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/10/02
 */
public class Solution {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        final Solution solution = new Solution();
        solution.spiralOrder(array2);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        final ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int size = matrix.length * matrix[0].length;
        while (result.size() < size) {
            for (int i = left; i <= right && result.size() < size; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && result.size() < size; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && result.size() < size; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && result.size() < size; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
