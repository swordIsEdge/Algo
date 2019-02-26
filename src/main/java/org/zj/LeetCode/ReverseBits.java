package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:54
 **/

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res >>>= 1;
            if (n < 0) {
                res|=0x80000000;
            } else {
                res |= 0x0;
            }
            n <<= 1;
        }
        return res;

    }
}
