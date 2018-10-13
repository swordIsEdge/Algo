package org.zj.LeetCode;

public class ZigZagConversion {
    public static void main(String... args) {
        String s = new ZigZagConversion().convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (numRows <= 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int n = 2 * numRows - 2;
        int len = s.length();

        for (int i = 0; i < len; i += n) {
            sb.append(s.charAt(i));
        }

        for (int i = 1; i < n / 2; i++) {
            int l = n - i;
            for (int j = 0; j < len; j += n) {
                if ((j + i) < len) {
                    sb.append(s.charAt(j + i));
                }
                if ((j + l) < len) {
                    sb.append(s.charAt(j + l));
                }
            }
        }
        for (int i = n / 2; i < len; i += n ) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
