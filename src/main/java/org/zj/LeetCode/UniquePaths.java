package org.zj.LeetCode;

/**
 * @program: Algo
 * @description: 3
 * @author: kasumi
 * @create: 2018-12-17 16:12
 **/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int sum = 2; sum <= m + n - 2; sum++) {
            int start = Math.max(1, sum + 1 - n);
            int end = Math.min(sum - 1, m - 1);
            for (int i = start; i <=end; i++) {
                res[i][sum - i] = res[i - 1][sum - i] + res[i][sum - i - 1];
            }
        }
        return res[m - 1][n - 1];


    }

    public static void main(String... args) {
        int m = 7;
        int n = 3;
        int res = new UniquePaths().uniquePaths(m, n);
        System.out.println(res);

    }
}
