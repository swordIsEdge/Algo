package org.zj.learn.dp;

public class LCS {
    static int N = 10;
    static int[][] mat = new int[N][N];

    public static void main(String... args) {
        char[] a = "kasumi".toCharArray();
        char[] b = "duci".toCharArray();
        lcs_dp(a, b);

    }

    public static int lcs_dp(char[] a, char[] b) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                if (a[i] == b[j])
                    mat[i][j] = 1 + mat[i + 1][j + 1];
                else
                    mat[i][j] = mat[i][j + 1] > mat[i + 1][j] ? mat[i][j + 1] : mat[i + 1][j];
            }
        }
        return mat[0][0];
    }
}
