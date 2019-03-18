package org.zj.nowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class 等差数列 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);
        int d = data[1] - data[0];
        for (int i = 0; i < n-1; i++) {
            if (data[i + 1] - data[i] != d) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
