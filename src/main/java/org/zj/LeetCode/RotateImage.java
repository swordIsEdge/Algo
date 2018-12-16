package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 20:40
 **/

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int coverageLength = 0;
        if (size % 2 == 1) {
            int media = size / 2;
            int tmp;
            for (int i = 0; i < media; i++) {
                tmp = matrix[media][i];
                matrix[media][i] = matrix[size - 1 - i][media];
                matrix[size - 1 - i][media] = matrix[media][size - 1 - i];
                matrix[media][size - 1 - i] = matrix[i][media];
                matrix[i][media] = tmp;
            }
            coverageLength = media - 1;
        } else {
            coverageLength = size / 2 - 1;
        }
        int tmp;
        for (int i = 0; i <= coverageLength; i++) {
            for (int j = 0; j <= coverageLength; j++) {
                tmp = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
                matrix[j][size-1-i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    public static void main(String... args){
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
