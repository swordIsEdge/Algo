package org.zj.nowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 彩色的砖块 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        switch (set.size()) {
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(0);
                break;
        }
    }
}
