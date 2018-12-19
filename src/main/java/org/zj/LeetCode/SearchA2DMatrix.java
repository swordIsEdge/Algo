package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 16:33
 **/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }

        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;

    }
}
