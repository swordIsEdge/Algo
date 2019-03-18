package org.zj.nowCoder;

import java.util.Scanner;

public class 交错01串 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int  tmp = 1, max = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                tmp = 1;
            } else {
                tmp++;
            }
            max = Math.max(max, tmp);

        }
        System.out.println(max);


    }
}
