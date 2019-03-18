package org.zj.LeetCode;

public class MinCostClimbingStairs{
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        if (len == 1) {
            return cost[0];
        }
        if (len == 2) {
            return Math.min(cost[0], cost[1]);

        }
        int[] fn = new int[len + 1];
        fn[0] = 0;
        fn[1] = 0;
        for (int i = 2; i <= len; i++) {
            fn[i] = Math.min(fn[i - 1] + cost[i - 1], fn[i - 2] + cost[i - 2]);
        }
        return fn[len];
    }
}
