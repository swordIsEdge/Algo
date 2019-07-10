package org.zj.LeetCode.medium;

/**
 * Created by kokoro at 2019/6/24
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if (lens == 0){
            return true;
        }
        if (lent < lens) {
            return false;
        }

        boolean[][] dp = new boolean[lens][lent];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int j = 1; j < lent; j++) {
            if (t.charAt(j) == s.charAt(0)) {
                dp[0][j] = true;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < lens; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = false;
            }
            for (int j = i; j < lent; j++) {
                if (dp[i - 1][j] && s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j] && dp[i][j - 1];
                }
            }
        }


        return dp[lens - 1][lent - 1];
    }
public static void main(String[] args){
    String s = "ltcode";
    String t = "yyyyyyyyyyyyyyyyyyyyyyyyyy";
    boolean res= new IsSubsequence().isSubsequence(s,t);
    System.out.println(res);
}
}
