package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-24 12:05
 **/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int n = nums.length;
        if (n == 1) {
            return nums;
        }
        int[] fromLeft = new int[n];
        fromLeft[0] = 1;
        int[] fromRight = new int[n];
        fromRight[n - 1] = 1;

        int[] res = new int[n];

        for (int i = 1; i < n; i++) {
            fromLeft[i] = fromLeft[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            fromRight[i] = fromRight[i + 1] * nums[i + 1];

        }
        for (int i = 0; i < n; i++) {
            res[i] = fromLeft[i] * fromRight[i];
        }
        return res;

    }
}
