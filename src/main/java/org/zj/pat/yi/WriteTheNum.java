package org.zj.pat.yi;

import java.util.Scanner;

public class WriteTheNum {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] resMap = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        String res = Integer.toString(sum);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length(); i++) {
            sb.append(resMap[res.charAt(i) - '0']);
            if (i < res.length() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());


    }
}
