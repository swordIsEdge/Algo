package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0, j = 0;
        while (j < len) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;

    }
@Test
    public void test() {
    int[] nums = {0,1,2,2,3,0,4,2};
    int val = 2;
    int res = removeElement(nums, val);
    int expLen = 5;
    int[] expNums = {0, 1, 3, 0, 4};

    Assert.assertEquals(expLen, res);
    Assert.assertTrue(compareSubArray(expNums, nums, res));
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
