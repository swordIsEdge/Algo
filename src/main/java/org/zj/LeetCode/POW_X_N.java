package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 19:10
 **/

public class POW_X_N {
    public double myPow(double x, int n) {
        double res=1;
        if (n == 0) {
            return 1;
        }
        int sign = n > 0 ? 1 : -1;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;
            res = x;
        } else {
            n = Math.abs(n);
        }


        int tmp = n;
        double tempPro = x;

        if ((tmp & 1) != 0) {
            res *= tempPro;
        }
        tmp = tmp >> 1;

        for (int i = 0; i < 30; i++) {
            tempPro *= tempPro;
            if ((tmp & 1) == 1) {
                res *= tempPro;
            }
            tmp = tmp >> 1;
            if (tmp == 0) {
                break;
            }
        }
        return sign > 0 ? res : 1 / res;

    }

    public static void main(String... args) {
        double x = 100;
        int n = 12;
        double res = new POW_X_N().myPow(x, n);
        System.out.println(res);

    }

}
