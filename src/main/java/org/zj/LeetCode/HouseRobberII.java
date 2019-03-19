package org.zj.LeetCode;

public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {
            int f = nums[0] > nums[1] ? nums[0] : nums[1];
            return f > nums[2] ? f : nums[2];
        }

        boolean[] hasOne = new boolean[len];
        int[] amount = new int[len];

        hasOne[0] = true;
        hasOne[1] = false;
        hasOne[2] = true;
        amount[0] = nums[0];
        amount[1] = nums[1];
        amount[2] = nums[0] + nums[2];
        for (int i = 3; i < len; i++) {
            if (amount[i - 2] > amount[i - 3]) {
                amount[i] = amount[i - 2] + nums[i];
                hasOne[i] = hasOne[i - 2];
            } else if (amount[i - 2] < amount[i - 3]) {
                amount[i] = amount[i - 3] + nums[i];
                hasOne[i] = hasOne[i - 3];
            } else {
                if (!hasOne[i - 2]) {
                    amount[i] = amount[i - 2] + nums[i];
                    hasOne[i] = hasOne[i - 2];
                } else {
                    amount[i] = amount[i - 3] + nums[i];
                    hasOne[i] = hasOne[i - 3];
                }
            }
        }
        if (amount[len - 2] >= amount[len - 1]) {
            //没用到最后一个，直接输出
            return amount[len - 2];
        }

        if (!hasOne[len - 1]) {
            return amount[len - 1];
        }

        int max = Math.max(amount[len - 2], amount[len - 3]);

        amount = new int[len];
        amount[0] = 0;
        amount[1] = nums[1];
        amount[2] = nums[2];
        amount[3] = nums[1] + nums[3];
        for (int i = 3; i < len; i++) {
            if (amount[i - 2] > amount[i - 3]) {
                amount[i] = amount[i - 2] + nums[i];
            } else {
                amount[i] = amount[i - 3] + nums[i];
            }
        }
        int nextMax = Math.max(amount[len - 1], amount[len - 2]);
        return Math.max(max, nextMax);

    }
}
