package org.zj.LeetCode.divideTwoIntegers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kokoro at 2018/10/16
 */
public class DivideTwoIntegers {
    //这个解法太垃圾了，超时了
    // 注意点1：divide(-2147483648,1)结果会溢出，需要处理
    // 注意点2：除法统一用负数表示，避免溢出。
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        int sign = 1;
        long res = 0;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 1) {
            res = sign * ldividend;
        } else {
            while (ldividend >= ldivisor) {
                res++;
                ldividend -= ldivisor;
            }
            res = res * sign;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    @Test
    public void test() {
        int dividend = -2147483648;
        int divisor = -3;
        int expect = 2147483647 / 3;
        int res = divide(dividend, divisor);
        Assert.assertEquals(expect, res);
    }
}



//    boolean isSameSign = (dividend < 0) == (divisor < 0);
//    int result = divide(Math.abs(dividend), Math.abs(divisor));
//    return isSameSign ? result : -result;


