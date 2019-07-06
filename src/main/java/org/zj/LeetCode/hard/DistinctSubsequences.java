package org.zj.LeetCode.hard;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-04-01 13:32
 **/

public class DistinctSubsequences {
    public static void main(String... args) {
        String s = "rabbbit";
        String t = "rabbit";
        DistinctSubsequences ds = new DistinctSubsequences();
        int res = ds.numDistinct(s, t);
        System.out.println(res);

    }

    public int numDistinct(String s, String t) {
        int lens = s.length(), lent = t.length();
        if (lens < lent) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[][] dpMatrx = new int[lent][lens];
        dpMatrx[0][0] = sChars[0] == tChars[0] ? 1 : 0;
        for (int i = 1; i < lens; i++) {
            dpMatrx[0][i] = tChars[0] == sChars[i] ? dpMatrx[0][i - 1] + 1 : dpMatrx[0][i - 1];
        }
        for (int i = 1; i < lent; i++) {
            dpMatrx[i][i] = tChars[i] == sChars[i] ? dpMatrx[i - 1][i - 1] : 0;
            for (int j = i + 1; j < lens; j++) {
                dpMatrx[i][j] = tChars[i] == sChars[j] ? dpMatrx[i][j - 1] + dpMatrx[i - 1][j - 1] : dpMatrx[i][j - 1];
            }
        }
        return dpMatrx[lent - 1][lens - 1];
    }
}
