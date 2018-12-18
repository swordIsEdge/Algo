package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 20:54
 **/

public class Sqrt_x {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int lo = 1, hi = x - 1, mid = lo + (hi - lo) / 2;
        double tmp;
        double next;
        while (lo <= hi) {
            tmp = 1.0 * mid * mid;
            if (tmp < 0) {
                hi = mid - 1;
            } else if (tmp > x) {
                hi = mid - 1;
            } else if (tmp == x) {
                return mid;
            } else {
                //tmp<x
                 next = 1.0 * (mid + 1) * (mid + 1);
                if (next < x) {
                    lo = mid + 1;
                } else if (next > x) {
                    return mid;
                } else {
                    return mid + 1;
                }
            }
            mid = lo + (hi - lo) / 2;

        }
        return mid;
    }

    public static void main(String... args) {
        int x = 2147395599;
        int res = new Sqrt_x().mySqrt(x);
        System.out.println(res);
    }
}
