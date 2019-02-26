package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 16:17
 **/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int res = 0;
        if (prices.length <= 1) {
            return res;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Integer.max(res, prices[i] - min);
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }

        return res;


    }
}
