package com.sustav.ALGORITHM.challenges.leetcode.medium.number_of_islands_200;

/**
 * @author Anton Sustavov
 * @since 2020/09/11
 */
public class Solution {
    private static int count;
    public static void main(String[] args) {
        ff(10,10);
        System.out.println(count);
    }

    private static int ff(int i, int i1) {
        if (i==0 || i1==0) {
            return 1;
        } else {
            count++;
            return ff(i-1, i1) + ff(i, i1-2);
        }

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    checkLand(grid, i, j);
                }
            }
        }
        return count;

    }

    public void checkLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        checkLand(grid, i+1, j);
        checkLand(grid, i-1, j);
        checkLand(grid, i, j+1);
        checkLand(grid, i, j-1);
    }
}
