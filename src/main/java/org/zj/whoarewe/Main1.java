package org.zj.whoarewe;

import java.util.Scanner;

public class Main1 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            long sum = 0;
            long tmp = 0;
            long sign = 1;
            for (char aChar : chars) {
                if (aChar >= '0' && aChar <= '9') {
                    tmp = tmp * 10 + (aChar - '0');
                } else if (aChar == '+') {
                    sum += sign * tmp;
                    sign = 1;
                    tmp = 0;
                } else {
                    sum += sign * tmp;
                    sign = -1;
                    tmp = 0;

                }
            }
            sum += sign * tmp;
            System.out.println(sum);
        }
    }
}
