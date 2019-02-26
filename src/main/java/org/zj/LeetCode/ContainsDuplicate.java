package org.zj.LeetCode;

import java.util.Arrays;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 12:23
 **/

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
