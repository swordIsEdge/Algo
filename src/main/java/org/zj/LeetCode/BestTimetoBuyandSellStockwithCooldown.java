package org.zj.LeetCode;

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String... args) {
        BestTimetoBuyandSellStockwithCooldown btc = new BestTimetoBuyandSellStockwithCooldown();
        int[] prices = {1, 2, 3, 0, 2};
        btc.maxProfit(prices);
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] dp = new int[len];

        int i = 0;
        dp[0] = 0;

        int min = prices[0];
        for (i=1; i < len; i++) {
            int tmp = prices[i];
            if (tmp <= min) {
                min = tmp;
                dp[i] = 0;
            } else {
                dp[i] = tmp - min;
                break;
            }
        }

        if (i == len) {
            return dp[i - 1];
        }
        for (i++; i < len; i++) {
            int tmp = Math.max(prices[i] - prices[0],prices[i]-prices[1]);
            for (int j = 0; j < i-2; j++) {
                tmp = Math.max(dp[j] + prices[i]- prices[j + 2], tmp);
            }
            if (tmp > dp[i - 1]) {
                dp[i] = tmp;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
