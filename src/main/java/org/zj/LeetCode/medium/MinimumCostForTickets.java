package org.zj.LeetCode.medium;

import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }
        int dayCount = days.length;
        if (dayCount == 1) {
            return minThree(costs[0], costs[1], costs[2]);
        }


        int[][] dp = new int[dayCount][3];
        dp[0][0] = costs[0];
        dp[0][1] = costs[1];
        dp[0][2] = costs[2];
        for (int i = 1; i < dayCount; i++) {
            int day = days[i];
            //find 1
            dp[i][0] = costs[0] + minThree(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
            //find 7
            int target = day - 7;
            int index = Arrays.binarySearch(days, target);
            if (index >= 0) {
                dp[i][1] = costs[1] + minThree(dp[index][0], dp[index][1], dp[index][2]);
            } else {
                index = -2 - index;
                if (index < 0) {
                    dp[i][1] = costs[1];
                } else {
                    dp[i][1] = costs[1] + minThree(dp[index][0], dp[index][1], dp[index][2]);

                }
            }
            //find 30
            target = day - 30;
            index = Arrays.binarySearch(days, target);
            if (index >= 0) {
                dp[i][2] = costs[2] + minThree(dp[index][0], dp[index][1], dp[index][2]);
            } else {
                index = -2 - index;
                if (index < 0) {
                    dp[i][2] = costs[2];
                } else {
                    dp[i][2] = costs[2] + minThree(dp[index][0], dp[index][1], dp[index][2]);

                }
            }


        }
        return minThree(dp[dayCount - 1][0], dp[dayCount - 1][1], dp[dayCount - 1][2]);
    }


    private int minThree(int a, int b, int c) {
        int res = Integer.min(a, Integer.min(b, c));
        return res;
    }

    public static void main(String[] args) {
        int[] kdays = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int res = new MinimumCostForTickets().mincostTickets(kdays, costs);
        System.out.println(res);
    }
}
