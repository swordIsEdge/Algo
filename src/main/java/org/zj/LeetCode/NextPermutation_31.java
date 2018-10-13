package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int j = len - 1;
        for (; j > 0 && nums[j] <= nums[j - 1]; j--) {

        }
        if (j == 0) {
            Arrays.sort(nums);
            return;
        }
        int i;
        for (i = len - 1; i >= j; i--) {
            if (nums[j - 1] < nums[i]) {
                break;
            }
        }

        {
            int tmp = nums[j - 1];
            nums[j - 1] = nums[i];
            nums[i] = tmp;
        }

        Arrays.sort(nums, j, len);
        return;
    }

    @Test
    public void test() {
        int[] nums = {5,1,1};
        int[] expect = {1, 3, 2};
        nextPermutation(nums);
        Assert.assertTrue(compareSubArray(expect, nums, nums.length));

    }

    private boolean compareSubArray(int[] expected, int[] actual, int len) {
        if (expected == null && actual == null) {
            return true;
        }
        if (expected == null || expected == null) {
            return false;
        }
        if (expected.length < len || actual.length < len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (expected[i] != actual[i]) {
                return false;
            }
        }
        return true;
    }

}
