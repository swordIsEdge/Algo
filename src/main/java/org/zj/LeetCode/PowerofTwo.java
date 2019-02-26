package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 12:38
 **/

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            n <<= 1;
            if (n < 0) {
                count++;
            }
        }
        return count == 1;

    }
}
