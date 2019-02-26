package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 18:22
 **/

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }



        int len = nums.length;
        int[] results = new int[len];
        results[0] = nums[0];
        results[1] = Math.max(nums[1], results[0]);
        for (int i = 2; i < len; i++) {
            results[i] = Math.max((results[i - 2] + nums[i]), results[i - 1]);
        }
        return results[len - 1];
    }
}
