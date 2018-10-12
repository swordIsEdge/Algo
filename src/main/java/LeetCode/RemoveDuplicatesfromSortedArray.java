package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i ;
        int j = 1;
        int len = nums.length;
        if (nums == null || nums.length < 1) {
            return 0;
        }
        i = 1;


        while (true) {
            while (j != len && nums[j] == nums[j - 1]) {
                j++;
            }
            if (j != len) {
                nums[i++] = nums[j++];
            } else {
                break;

            }
        }
        return i ;
    }

    @Test
    public void test() {
//        int[] input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] expect = new int[]{0, 1, 2, 3, 4};//
 int[] input = new int[]{1};
        int[] expect = new int[]{1};
        int resLen = removeDuplicates(input);
//        int expectLen = 5;
        int expectLen = 1;

        Assert.assertEquals(expectLen, resLen);
        Assert.assertTrue(compareSubArray(expect,input,resLen));

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
