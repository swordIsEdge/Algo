package org.zj.LeetCode.hard;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int[] l2r = new int[len];
        int[] r2l = new int[len];

        l2r[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l2r[i] = l2r[i - 1] + 1;
            } else {
                l2r[i] = 1;
            }
        }
        r2l[len - 1] = 1;
        for (int i = len-2;i>=0;i--) {
            if (ratings[i] > ratings[i + 1]) {
                r2l[i] = 1 + r2l[i + 1];
            } else {
                r2l[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(l2r[i], r2l[i]);
        }
        return sum;
    }
}
