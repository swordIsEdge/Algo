package org.zj.pat.yi;

import java.util.Scanner;

public class StringAPlusB {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] bSet = new boolean[128];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (char aChar : chars) {
                if (!bSet[aChar]) {
                    bSet[aChar] = true;
                    sb.append(aChar);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
