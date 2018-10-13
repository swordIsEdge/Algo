package org.zj.pat.yi;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            sb.append(ss[i]);
            sb.append(" ");
        }
        System.out.println(sb.subSequence(0,sb.length()-1));
    }
}
