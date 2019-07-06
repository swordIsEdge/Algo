package org.zj.LeetCode.medium;

import java.util.Arrays;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int tmp = nums[0]; //当前数的值
        int n = 1; //不同的数的总数
        int index = 0; //指向当前数的和的指针
        int[] sum = new int[nums.length];
        int[] single = new int[nums.length];
        single[0] = tmp;
        for (int i : nums) {
            if (i != tmp) {
                tmp = i;
                n++;
                index++;
                single[index] = tmp;
            }
            sum[index] += tmp;
        }

        if (n == 1) {
            return sum[0];
        }
        if (n == 2) {
            return Integer.max(sum[0], sum[1]);
        }


        int[] dp = new int[n];
        dp[0] = sum[0];
        dp[1] = Integer.max(sum[0], sum[1]);
        for (int i = 2; i < n; i++) {
            if (single[i - 1] + 1 == single[i]) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);

            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]) + sum[i];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 3, 3, 3, 4};
        int res = new DeleteAndEarn().deleteAndEarn(num);
        System.out.println(res);
    }
}
