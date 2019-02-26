package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-01-14 14:25
 **/

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return true;
        }
        int len = s1.length();
        if (len % 2 == 0) {
            String s1Left = s1.substring(0, len / 2);
            String s1Right = s1.substring(len / 2);

            String s2Left = s2.substring(0, len / 2);
            String s2Right = s2.substring(len / 2);
            return (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) ||
                    (isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left));
        } else {
            int mid = len / 2;



        }
        return false;


    }

}
