package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 10:15
 **/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minimum = Integer.MAX_VALUE;
        boolean hasResult =false;

        int i = 0, j = 0;
        int sum = nums[0];
        int len;
        while (true) {
            if (sum >= s) {
                hasResult = true;
                len = j - i + 1;
                minimum = Integer.min(minimum, len);
                sum -= nums[i];
                i++;
            } else {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                } else {
                    break;
                }
            }


        }
        return hasResult ? minimum : 0;
    }
}
