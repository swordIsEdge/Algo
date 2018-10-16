package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kokoro at 2018/10/16
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor can't be zero");
        }
        if (dividend == 0) {
            return 0;
        }
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long res = 0;
        while ((ldividend -= ldivisor) >= 0) {
            res++;
        }
        res *= sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;

    }

    @Test
    public void test() {
        int dividend = 2147483647;
        int divisor = 1;
        int expect = 2147483647;
        int res = divide(dividend, divisor);
        Assert.assertEquals(expect, res);
    }
}
