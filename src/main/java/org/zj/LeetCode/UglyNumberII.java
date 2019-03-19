package org.zj.LeetCode;

import java.util.BitSet;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
        int[] res = new int[n];
        res[0] = 1;
        int p22 = 0, p23 = 0, p25 = 0;
        for (int i = 1; i < n; i++) {
            int result2 = res[p22] << 1;
            int result3 = res[p23] + (res[p23] << 1);
            int result5 = res[p25] + (res[p25] << 2);
            res[i] = Math.min(result2, Math.min(result3, result5));
            if (res[i] == result2) {
                p22++;
            }
            if (res[i] == result3) {
                p23++;
            }
            if (res[i] == result5) {
                p25++;
            }
        }
        return res[n - 1];
    }

    int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }

    public static void main(String... args) {
        int n = new UglyNumberII().nthUglyNumber(10);
        System.out.println(n);
    }
}
