package org.zj.nowCoder;

import java.util.Scanner;

public class IntegerInverse {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sign = n<0?-1:1;
        String s = new StringBuilder(Math.abs(n)+"").reverse().toString();
        int res = 0;
        try {
            res = Integer.parseInt(s) * sign;

        } catch (Exception e) {
            res = n < 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        System.out.println(res);

    }
}
