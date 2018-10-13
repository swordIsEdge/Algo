package org.zj.sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        int a = 0, b = 1;
        int temp;
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n-1; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;

    }

}
