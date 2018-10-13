package org.zj.sword2offer;

import java.util.ArrayList;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
//本代码已经失败
public class PrintMatrix {
    public static void main(String... args) {
        PrintMatrix pm = new PrintMatrix();
//        int[][]matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> result = pm.printMatrix(matrix);
        for (int i : result) {
            System.out.print(i);
            System.out.print("  ");
        }


    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        int lineNum = matrix.length,
                rowNum = matrix[0].length;

// 第一个点是0,0
// 每个while循环中画一个圈
// while结尾计算下一个圈开始的点，并判断是否有效，无效则退出
// while循环中用四个for循环画出右、下、左、上的圈。
//        注意调整边界
        ArrayList<Integer> result = new ArrayList<>();
        int upBound = -1,
                rightBound = rowNum,
                downBound = lineNum,
                leftBound = -1;

        //第一个点是（0,0）
        int i = 0, j = 0;


        while (true) {
            for (; i <= rightBound - 1; i++) {
                result.add(matrix[j][i]);
            }
            j++;
            upBound++;

            for (; j <= downBound - 1; j++) {
                result.add(matrix[j][i]);
            }
            i--;
            rightBound--;

            for (; i >= leftBound - 1; i--) {
                result.add(matrix[j][i]);
            }
            j--;
            downBound--;

            for (; j >= upBound - 1; j--) {
                result.add(matrix[j][i]);
            }
            i++;
            leftBound++;

//            i++;//计算下一圈的起点
            if (i <= leftBound || i >= rightBound || j <= upBound || j >= downBound) {
                break;
            }

        }
        return result;

    }
}
