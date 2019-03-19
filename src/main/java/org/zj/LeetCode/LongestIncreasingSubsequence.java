package org.zj.LeetCode;

import java.util.Arrays;

/**
 *
 */
public class LongestIncreasingSubsequence {
    public static void main(String... args) {
        int[] nums = {2, 5, 6, 3, 7};
        new LongestIncreasingSubsequence().lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j]);

            }
            System.out.println();
        }


        return len;
    }
}
