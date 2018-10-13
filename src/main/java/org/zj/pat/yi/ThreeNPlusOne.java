package org.zj.pat.yi;

import java.util.Scanner;

public class ThreeNPlusOne {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n + 1) / 2;
            }
            count++;
        }
        System.out.println(count);
    }
}
