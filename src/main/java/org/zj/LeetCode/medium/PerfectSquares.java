package org.zj.LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class PerfectSquares
{
    public int numSquares(int n) {
        int i = 1;
        Set<Integer> set = new HashSet<>();
        int[] res = new int[n+1];
        res[0] = 0;
        for (int j = 1; j <=n; j++) {
            if (j >= i * i) {
                set.add(i*i);
                i++;
            }
            int min = Integer.MAX_VALUE;
            for (Integer integer : set) {
                min = Integer.min(min,res[j-integer]);
            }
            res[j] = min+1;

        }
        return res[n];

    }

    public static void main(String[] args) {
        int n = 1;
        int res = new PerfectSquares().numSquares(n);
        System.out.println(res);

    }
}
