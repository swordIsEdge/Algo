package org.zj.LeetCode;

public class String2Integer {
    public static void main(String... args){
        int s = new String2Integer().myAtoi("+");
        System.out.println(s);
    }
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int index = 0;
        for (index = 0; index < str.length(); index++) {
            if (str.charAt(index) != ' ') {
                break;
            }
        }
        String nstr = str.substring(index);
        if (nstr.isEmpty()) {
            return 0;
        }
        int sign = 1;
        char first = nstr.charAt(0);
        if (first == '+') {
            sign = 1;
            nstr = nstr.substring(1);
        } else if (first == '-') {
            sign = -1;
            nstr = nstr.substring(1);
        } else if (!Character.isDigit(first)) {
            return 0;
        }

        int end;
        for ( end = 0; end < nstr.length(); end++) {
            if (!Character.isDigit(nstr.charAt(end))) {
                break;
            }
        }
        nstr = nstr.substring(0, end);
        if (nstr.isEmpty()) {
            return 0;
        }
        int res;
        try {
            res = Integer.parseInt(nstr)*sign;
        } catch (NumberFormatException e) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return res;




    }
}
