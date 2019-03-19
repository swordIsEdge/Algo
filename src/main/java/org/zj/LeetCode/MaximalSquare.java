package org.zj.LeetCode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] data = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            data[i][0] = matrix[i][0] - '0';
            max = Math.max(data[i][0], max);

        }
        for (int i = 0; i < col; i++) {
            data[0][i] = matrix[0][i] - '0';
            max = Math.max(data[0][i], max);

        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    data[i][j] = 0;
                } else {
                    int min = Math.min(data[i - 1][j], Math.min(data[i][j - 1], data[i - 1][j - 1]));
                    data[i][j] = 1+min;
                    max = Math.max(data[i][j], max);
                }
            }
        }
        return max*max;

    }

    public static void main(String... args) {
//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = new char[][]{{'1'}};
        new MaximalSquare().maximalSquare(matrix);
    }
}
