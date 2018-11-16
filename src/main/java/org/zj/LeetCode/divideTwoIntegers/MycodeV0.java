package org.zj.LeetCode.divideTwoIntegers;

public class MycodeV0 {
    //unsolved
    public static void main(String... args){
        int a = 10;
        int b = 3;
        int res = new MycodeV0().devide(a, b);
        System.out.println(res);


    }

    public int devide(int dividend, int divisor) {
        //唯一的负数转正数会溢出的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend ^ divisor) >>> 31) == 1 ? -1 : 1;
        return sign * devideCore(dividend < 0 ? dividend : (~dividend + 1), divisor < 0 ? divisor : (~divisor + 1));
    }

    public int devideCore(int dividend, int divisor) {
        int res = 0;
        int tmp = divisor;
        int eq = 0;
        while (tmp<<1 > dividend) {
            tmp<<=1;
            eq++;
        }
        for(int i = eq; i >= 0; i--) {
            int ntemp = divisor << i;
            if (dividend <= ntemp) {
                dividend -= ntemp;
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }
        }
        return Math.abs(res);
    }


}
