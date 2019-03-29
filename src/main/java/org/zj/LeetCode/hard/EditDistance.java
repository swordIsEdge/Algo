package org.zj.LeetCode.hard;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dpMatrix = new int[m + 1][n + 1];
        for (int i = 0; i <=m; i++) {
            dpMatrix[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dpMatrix[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            char a = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = word2.charAt(j - 1);
                if (a == b) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                } else {
                    dpMatrix[i][j] = 1 + Math.min(dpMatrix[i - 1][j - 1], Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j]));

                }
            }
        }
        return dpMatrix[m][n];

    }
}
