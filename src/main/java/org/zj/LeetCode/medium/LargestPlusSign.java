package org.zj.LeetCode.medium;

import sun.nio.cs.ext.MacDingbat;

/**
 * Created by kokoro at 2019/6/24
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N == 1) {
            if (mines.length > 0 && mines[0][0] == 0 && mines[0][1] == 0) {
                return 0;
            }
            return 1;
        }
        boolean[][] matrixs = new boolean[N][N];
        for (int[] mine : mines) {
            matrixs[mine[0]][mine[1]] = true;
        }
        int[][] matricRight = new int[N][N], matricLeft = new int[N][N], matricUp = new int[N][N], matricDown = new int[N][N];
        for (int i = 0; i < N; i++) {
            matricRight[i][0] = 0;
            for (int j = 1; j < N; j++) {
                if (matrixs[i][j - 1]) {
                    matricRight[i][j] = 0;
                } else {
                    matricRight[i][j] = matricRight[i][j - 1] + 1;
                }
            }
            matricLeft[i][N - 1] = 0;
            for (int j = N - 2; j >= 0; j--) {
                if (matrixs[i][j + 1]) {
                    matricLeft[i][j] = 0;
                } else {
                    matricLeft[i][j] = matricLeft[i][j + 1] + 1;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            matricDown[0][j] = 0;
            for (int i = 1; i < N; i++) {
                if (matrixs[i - 1][j]) {
                    matricDown[i][j] = 0;
                } else {
                    matricDown[i][j] = matricDown[i - 1][j] + 1;
                }
            }
            matricUp[N - 1][j] = 0;
            for (int i = N - 2; i >= 0; i--) {
                if (matrixs[i + 1][j]) {
                    matricUp[i][j] = 0;
                } else {
                    matricUp[i][j] = matricUp[i + 1][j] + 1;
                }
            }
        }
        int max = 0;
        int[][] minMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrixs[i][j]) {
                    minMatrix[i][j] = 0;
                } else {
                    minMatrix[i][j] = minFour(matricLeft[i][j], matricRight[i][j], matricUp[i][j], matricDown[i][j])+1;
                }
                max = Integer.max(max, minMatrix[i][j]);
            }
        }
        return max;

    }

    private int minFour(int a, int b, int c, int d) {
        int res = Integer.min(Integer.min(a, b), Integer.min(c, d));
        return res;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] mine = {{4, 2}};
        int res = new LargestPlusSign().orderOfLargestPlusSign(N, mine);
        System.out.println(res);
    }
}
