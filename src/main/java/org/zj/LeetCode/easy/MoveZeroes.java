package org.zj.LeetCode.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int countZero = 0;
        for (int num : nums) {
            countZero += (num == 0 ? 1 : 0);
        }
        for (int i = 0,j = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[j++] = nums[i];
        }
        for (int i = len-countZero; i < len; i++) {
            nums[i] = 0;
        }

    }
}
