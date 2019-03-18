package org.zj.byteDance;

import java.util.Scanner;

public class Byte2 {
    public static void core(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 1, k = 2;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if (len <= 2) {
            System.out.println(s);
        }
        if (len == 3) {
            if (chars[0] == chars[1]&& chars[1] == chars[2]) {
                sb.append(chars[0]);
                sb.append(chars[0]);
                System.out.println(sb.toString());
            }
        }


        while (k < len) {
            if (chars[i] != chars[j]) {
                sb.append(chars[i]);
                i=j;
                j=k;
                k++;
            } else  {//chars[i]==chars[j]
                if (chars[j] == chars[k]) {
                    k++;
                } else if (k + 1 < len && chars[k] == chars[k + 1]) {
                    k++;
                } else {
                    sb.append(chars[i]);
                    sb.append(chars[j]);
                    i = k;
                    j = i+1;
                    k = i + 2;
                }
            }
        }
        if (i < len) {
            sb.append(chars[i]);
        }
        if (j < len) {
            sb.append(chars[j]);
        }
        System.out.println(sb.toString());

    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i <n; i++) {
            String line = sc.nextLine();
            core(line);
        }
    }
}
