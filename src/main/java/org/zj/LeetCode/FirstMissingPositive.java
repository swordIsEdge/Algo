package org.zj.LeetCode;

import java.util.Arrays;

/**
 * @program: Algo
 * @description: .
 * @author: kasumi
 * @create: 2018-12-16 16:18
 **/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int[] temp = new int[max+1];
        for (int i = 0; i < max+1; i++) {
            temp[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            temp[nums[i]] = nums[i];
        }
        for (int i = 1; i < max + 1; i++) {
            if (temp[i] == -1) {
                return i;
            }
        }
        return max+1;

    }

}
