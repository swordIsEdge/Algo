package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 09:56
 **/

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m < 0 || n < m) {
            return 0;
        }

        if (m == 0) {
            return 0;
        }

        int mShift = m, nShift = n;
        int result = 0;
        int shiftBits = 1;
        for (; shiftBits <= 31; shiftBits++) {
            mShift <<= 1;
            nShift <<= 1;
            result <<= 1;

            if (mShift >= 0 && nShift >= 0) {
                result = result | 0x0000;
            } else if (mShift < 0 && nShift < 0) {
                result = result | 0x0001;
            } else {
                break;
            }

        }
        if (shiftBits == 32) {
            return result;
        }
        result <<=(31 - shiftBits);
        return result;
    }
    public static void main(String... args){
        BitwiseANDofNumbersRange bitwiseANDofNumbersRange = new BitwiseANDofNumbersRange();
        int res = bitwiseANDofNumbersRange.rangeBitwiseAnd(1, 1);
        System.out.print(res);
    }
}
