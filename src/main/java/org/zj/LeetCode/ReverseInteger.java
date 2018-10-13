package org.zj.LeetCode;

public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }

        String sx = String.valueOf(x);
        StringBuilder sb = new StringBuilder();

        for (int i = sx.length() - 1; i >= 0; i--) {
            sb.append(sx.charAt(i));
        }
        int start;
        for (start = 0; start < sb.length(); start++) {
            if (sb.charAt(start) != 0) {
                break;
            }
        }
        String sRes = sb.substring(start);
        int res = 0;
        try {
            res = Integer.parseInt(sRes);
        } catch (NumberFormatException e) {
            return 0;
        }

        res = sign * res;
        return res;
    }

    public static void main(String... args) {
        int res = new ReverseInteger().reverse(1534236469);
        System.out.println(res);
    }
}
