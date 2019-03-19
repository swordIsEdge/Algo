package org.zj.LeetCode;

public class CountingBits {
    public int[] countBits(int num) {

        if (num < 0) {
            return new int[0];
        }
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0,1};
        }

        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;

        int ex = 1;

        for (int i = 2; i <=num; i++) {
            if (i == ex << 1) {
                res[i] = 1;
                ex <<= 1;
            } else {
                res[i] = res[ex] + res[i - ex];
            }

        }
        return res;


    }
}
