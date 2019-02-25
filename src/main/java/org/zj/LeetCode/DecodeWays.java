package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 12:23
 **/

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0||s.charAt(0)=='0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }


        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int lastTwo = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            count[i] = (s.charAt(i - 1) == '0' ? 0 : count[i - 1]) + (lastTwo > 26 || s.charAt(i - 2) == '0' ? 0 : count[i - 2]);
        }
        return count[s.length()];
    }

    public static void main(String... args) {
        String s = "10";
        int res = new DecodeWays().numDecodings(s);
        System.out.println(res);

    }
}
