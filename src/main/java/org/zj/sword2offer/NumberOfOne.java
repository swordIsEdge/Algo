package org.zj.sword2offer;

import java.util.Scanner;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class NumberOfOne {
    public int NumberOf1(int n) {
        int num = n;
        int count = 0;
        while (num != 0) {
            if (num<0) {
                count++;
            }
            num = num << 1;
        }
        return count;

    }
    public static void main(String... args){
        NumberOfOne no = new NumberOfOne();
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            System.out.println(no.NumberOf1(n));
        }
    }
}
