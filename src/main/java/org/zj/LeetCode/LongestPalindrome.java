package org.zj.LeetCode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 0;
        int lo = 0;
        String res;
        boolean[][] isPal = new boolean[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = i; j >= 0; j--) {
                boolean a = s.charAt(i) == s.charAt(j);
                boolean b = (i - j < 3) || isPal[j + 1][i - 1];
                isPal[j][i] = a && b;
                if (isPal[j][i] && maxLen < i - j + 1) {
                    maxLen = i - j + 1;
                    lo = j;
                }
            }
        }
        res = s.substring(lo, maxLen + lo);
        return res;


    }

    public static void main(String... args) {
        LongestPalindrome lp = new LongestPalindrome();
        String res = lp.longestPalindrome("babad");
        System.out.println(res);
    }

}
