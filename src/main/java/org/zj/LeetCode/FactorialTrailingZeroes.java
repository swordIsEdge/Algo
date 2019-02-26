package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:58
 **/

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        n = n - n % 5;
        while (n != 0) {
            n = n / 5;
            res = res + n;
        }
        return res;
    }
    public static void main(String... args){
        FactorialTrailingZeroes test = new FactorialTrailingZeroes();
        int a = test.trailingZeroes(32);
        System.out.println(a);
    }

}
