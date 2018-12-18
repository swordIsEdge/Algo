package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 20:50
 **/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        int last = 2;
        int lastlast = 1;
        for (int i = 3; i <= n; i++) {
            res = last + lastlast;
            lastlast = last;
            last = res;
        }
        return res;
    }
    public static void main(String... args){

    }
}
