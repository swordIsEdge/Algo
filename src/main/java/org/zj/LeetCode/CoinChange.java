package org.zj.LeetCode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        if (len < 1 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (len == 1 && (amount < coins[0] || amount % coins[0] != 0)) {
            return -1;
        }
        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < len && coins[j]<=i; j++) {
                tmp = Math.min(tmp, dp[i - coins[j]]);
            }
            if (tmp < Integer.MAX_VALUE) {
                dp[i] = tmp + 1;
            }
        }
        return dp[amount] <Integer.MAX_VALUE ? dp[amount] : -1;
    }
    public static void main(String... args) {
        CoinChange cc = new CoinChange();
        int[] coins = {186,419,83,408};
        int amout = 6249;
        int res = cc.coinChange(coins, amout);
        System.out.println(res);

    }
}
