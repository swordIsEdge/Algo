package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 10:30
 **/

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0 ) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        boolean[][] used = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (used[i][j]) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    core(i, j, row, col, grid, used);
                    count++;
                }
            }
        }
        return count;

    }

    public void core(int i, int j, int row, int col, char[][] grid, boolean[][] used) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        used[i][j] = true;
        if (grid[i][j] == '0') {
            return;
        }
        core(i - 1, j, row, col, grid, used);
        core(i + 1, j, row, col, grid, used);
        core(i, j - 1, row, col, grid, used);
        core(i, j + 1, row, col, grid, used);


    }
}
