package org.zj.sword2offer;

import java.util.ArrayList;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class PrintMatrix2 {
    public static void main(String... args) {
        PrintMatrix2 pm = new PrintMatrix2();
        int[][]matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
//        int[][] matrix = {{1,2},{3,4}};
        pm.printMatrix(matrix);

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }


        int lineNum = matrix.length,
                rowNum = matrix[0].length;

        int start = 0,
                endX = rowNum - 1,
                endY = lineNum - 1;
        int x, y;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (start * 2 < lineNum && start * 2 < rowNum) {
            //此循环中打印一个圈
            //需要判断最后只剩一行或一列的情况
            for (x = start; x <= endX; x++) {
                arrayList.add(matrix[start][x]);
            }

            if (start < endY) {
                for (y = start + 1; y <= endY; y++) {
                    arrayList.add(matrix[y][endX]);
                }
            }

            if (start < endX && start < endY) {
                for (x = endX - 1; x >= start; x--) {
                    arrayList.add(matrix[endY][x]);
                }
            }

            if (start < endX && start + 1 < endY) {
                for (y = endY - 1; y > start; y--) {
                    arrayList.add(matrix[y][start]);
                }
            }
            endX--;
            endY--;
            start++;
        }//end while
        return arrayList;

    }
}
