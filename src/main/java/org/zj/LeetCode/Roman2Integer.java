package org.zj.LeetCode;

//Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
public class Roman2Integer {
    public int romanToInt(String s) {
        String[] keys = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int sum = 0;
        for (int i = 0; i < keys.length; i++) {
            while (s.endsWith(keys[i])) {
                sum += values[i];
                s = s.substring(0, s.length() - keys[i].length());
            }
        }
        return sum;
    }
}
