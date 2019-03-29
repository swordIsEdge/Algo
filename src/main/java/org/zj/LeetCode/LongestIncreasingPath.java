package org.zj.LeetCode;

public class LongestIncreasingPath {
    public static int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int dp[][] = new int[matrix.length][matrix[0].length];   //动归矩阵

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //要求当前位置的最长递增路径，需求当前位置往上下左右分别的最大递增路径。
                max = Math.max(max, maxIncrease(matrix, dp, row + 1, col, matrix[row][col]) + 1);   //下
                max = Math.max(max, maxIncrease(matrix, dp, row - 1, col, matrix[row][col]) + 1);   //上
                max = Math.max(max, maxIncrease(matrix, dp, row, col + 1, matrix[row][col]) + 1);    //右
                max = Math.max(max, maxIncrease(matrix, dp, row, col - 1, matrix[row][col]) + 1);    //左
            }
        }
        return max;
    }

    private static int maxIncrease(int[][] matrix, int[][] dp, int row, int col, int pre) { //往当前方向走的最长递增路径
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] >= pre) {
            return 0;
        }

        if (dp[row][col] == 0) {          //当前位置没有计算过
            dp[row][col] = maxIncrease(matrix, dp, row + 1, col, matrix[row][col]) + 1;
            dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row, col + 1, matrix[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row - 1, col, matrix[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row, col - 1, matrix[row][col]) + 1);
        }
        return dp[row][col];
    }

}
