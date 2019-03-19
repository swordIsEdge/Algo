package org.zj.LeetCode;

public class RangeSumQuery2D {
    public static void main(String... args) {
        int[][] matrix = {{1}, {-7}};
        NumMatrix nm = new NumMatrix(matrix);
        nm.sumRegion(0, 0, 0, 0);
        nm.sumRegion(1, 0, 1, 0);
        nm.sumRegion(0, 0, 1, 0);
    }

}

class NumMatrix {
    int[][] dp;
    int row, col;

    public NumMatrix(int[][] matrix) {
        row = matrix.length;
        if (row == 0) {
            return;
        }
         col = matrix[0].length;
        if (col == 0) {
            return;
        }

        dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row == 0 || col == 0) {
            return 0;
        }
        if (row1 >= row || row2 >= row || col1 >= col || col2 >= col) {
            return 0;
        }

        if (row1 == 0 && col1 == 0) {
            return dp[row2][col2];
        }
        if (row1 == 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        }
        if (col1 == 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        }
        return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];

    }

}
