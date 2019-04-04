package org.zj.LeetCode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        boolean[] bu = new boolean[len + 1];
        for (int num : nums) {
            bu[num] = true;
        }
        for (int i = 0; i <=len; i++) {
            if (!bu[i]) {
                return i;
            }
        }
        return 0;
    }
}
