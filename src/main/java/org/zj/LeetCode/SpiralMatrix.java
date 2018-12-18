package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 12:36
 **/

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;

//        int row = 4;
//        int col = 3;
        int left = 0;
        int up = 0;

        int i = 0, j = 0;

        while (true) {
            for (; j < col; j++) {
                result.add(matrix[i][j]);
//                System.out.println("( " + i + ", " + j + " )");
            }
            j--;
            up++;
            i++;
            if (up >= row) {
                break;
            }
            for (; i < row; i++) {
                result.add(matrix[i][j]);
//                System.out.println("( " + i + ", " + j + " )");

            }
            j--;
            col--;
            i--;
            if (left >= col) {
                break;

            }

            for (; j >= left; j--) {
                result.add(matrix[i][j]);
//                System.out.println("( " + i + ", " + j + " )");

            }
            i--;
            row--;
            j++;
            if (up >= row) {
                break;

            }

            for (; i >= up; i--) {
                result.add(matrix[i][j]);
//                System.out.println("( " + i + ", " + j + " )");

            }
            i++;
            left++;
            j++;
            if (left >= col) {
                break;

            }
//            System.out.println();
        }
        return result;
    }

    public static void main(String... args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(res);

    }
}
