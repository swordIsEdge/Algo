package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 14:24
 **/

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        if (n == 1) {
            int[][] res = {{1}};
            return res;
        }

        int[][] result = new int[n][n];

        int count = 1;
        int left = 0, right = n, up = 0, down = n;
        int i = 0, j = 0;
        while (true) {
            for (; j < right; j++) {
                result[i][j] = count++;
//                System.out.println("("+i+", "+j+")");
            }
            j--;
            i++;
            up++;
            if (up > down) {
                break;
            }
            for (; i < down; i++) {
                result[i][j] = count++;
//                System.out.println("("+i+", "+j+")");

            }
            i--;
            j--;
            right--;
            if (left > right) {
                break;
            }
            for (; j >= left; j--) {
                result[i][j] = count++;
//                System.out.println("("+i+", "+j+")");

            }

            i--;
            j++;
            down--;
            if (up > down) {
                break;
            }
            for (; i >= up; i--) {
                result[i][j] = count++;
//                System.out.println("("+i+", "+j+")");

            }
            i++;
            j++;
            left++;
            if (left > right) {
                break;
            }

        }
//        System.out.println();
        return result;


    }
    public static void main(String... args){
        SpiralMatrixII s = new SpiralMatrixII();
        for (int i = 2; i < 9; i++) {
            s.generateMatrix(i);
            System.out.println();

        }
    }
}
