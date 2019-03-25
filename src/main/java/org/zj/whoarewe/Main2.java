package org.zj.whoarewe;

import java.util.Scanner;

public class Main2 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] uppers = new int[26];
            int[] lowwers = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if ('a' <= c && c <= 'z') {
                    lowwers[c - 'a']++;
                } else if ('A' <= c && c <= 'Z') {
                    uppers[c - 'A']++;
                }
            }
            int[] summon = new int[26];
            for (int i = 0; i <= 25; i++) {
                summon[i] = Math.min(uppers[i], lowwers[i]);
            }

            StringBuilder sb;
            boolean has = false;
            for (int i = 0; i <= 25; i++) {
                while (summon[i] > 0) {
                    sb = new StringBuilder();
                    for (int j = i;  j <= 25 &&summon[j] > 0; j++) {
                        summon[j]--;
                        sb.append((char) ('A' + j));
                        sb.append((char) ('a' + j));
                    }
                    if (sb.length() > 0) {
                        System.out.println(sb.toString());
                        has = true;
                    }
                }
            }
            if (!has) {
                System.out.println("Not Found");
            }
        }
    }
}