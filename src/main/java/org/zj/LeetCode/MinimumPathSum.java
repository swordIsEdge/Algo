package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 17:30
 **/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = grid[i][0] + res[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = grid[0][i] + res[0][i - 1];
        }
        for (int sum = 2; sum <= m + n - 2; sum++) {
            int start = Math.max(1, sum + 1 - n);
            int end = Math.min(sum - 1, m - 1);
            for (int i = start; i <=end; i++) {
                res[i][sum - i] = grid[i][sum - i] + Math.min(res[i - 1][sum - i], res[i][sum - i - 1]);
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String... args){
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int res = new MinimumPathSum().minPathSum(grid);
        System.out.println(res);

    }
}
