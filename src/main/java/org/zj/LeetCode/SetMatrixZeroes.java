package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 16:48
 **/

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 ) {
            return;
        }
        int row = matrix.length, col = matrix[0].length;

        int fx = 0, fy = 0;
        //扫描到的第一个位置
        getFirst:
        for (fx = 0; fx < row; fx++) {
            for (fy = 0; fy < col; fy++) {
                if (matrix[fx][fy] == 0) {
                    break getFirst;
                }
            }
        }

        if (fx == row && fy == col) {
            //没有值为0的点
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0){
                matrix[i][fy] = 0;
                matrix[fx][j] = 0;}

            }
        }

        for (int i = 0; i < row; i++) {
            if (i == fx) {
                continue;
            }
            if (matrix[i][fy] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            if (j == fy) {
                continue;
            }
            if (matrix[fx][j] == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            matrix[i][fy] = 0;
        }
        for (int j = 0; j < col; j++) {
            matrix[fx][j] = 0;
        }
        return;
    }

    public static void main(String... args) {
        int[][] matrix = {
                {0, 1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }

    }
}
