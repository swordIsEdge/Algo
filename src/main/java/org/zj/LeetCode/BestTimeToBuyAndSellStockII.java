package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 18:04
 **/

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length <= 1) {
            return result;
        }

        int min = prices[0], max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i];
            if (tmp >= max) {
                max = tmp;
            } else {
                result += (max - min);
                max = tmp;
                min = tmp;
            }
        }
        result += (max - min);
        return result;
    }

}
