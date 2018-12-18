package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 16:34
 **/

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
//        if (m == 1 || n == 1) {
//            return 1 - obstacleGrid[0][0];
//        }

        int[][] res = new int[m][n];
        res[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] * (1 - obstacleGrid[i][0]);
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] * (1 - obstacleGrid[0][i]);
        }
        for (int sum = 2; sum <= m + n - 2; sum++) {
            int start = Math.max(1, sum + 1 - n);
            int end = Math.min(sum - 1, m - 1);
            for (int i = start; i <= end; i++) {
                res[i][sum - i] = (res[i - 1][sum - i] + res[i][sum - i - 1]) * (1 - obstacleGrid[i][sum - i]);
            }
        }
        return res[m - 1][n - 1];


    }


    public static void main(String... args) {
        int[][] obs = {{1, 0}};
        int res = new UniquePathsII().uniquePathsWithObstacles(obs);
        System.out.println(res);

    }
}
