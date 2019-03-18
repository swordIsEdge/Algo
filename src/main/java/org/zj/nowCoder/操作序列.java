package org.zj.nowCoder;

import java.util.LinkedList;
import java.util.Scanner;

public class 操作序列 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        LinkedList<Integer> data = new LinkedList<>();
        for ( i = 0; i < n; i++) {
            if (i % 2 == 0) {
                data.push(scanner.nextInt());

            } else {
                data.add(scanner.nextInt());
            }
        }
        if (n % 2 == 0) {
            while (!data.isEmpty()) {
                System.out.print(data.getLast()+(data.isEmpty()?"":" "));

            }

        } else {
            while (!data.isEmpty()) {
                System.out.print(data.poll()+(data.isEmpty()?"":" "));
            }
        }
    }
}
