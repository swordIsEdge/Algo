package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kokoro at 2018/10/16
 */
//No duplicate
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int len = nums.length, lastIndex = len - 1;
        int lo = 0,
                hi = lastIndex,
                mid;
        if (nums[lastIndex] < nums[0]) {
            if (target >= nums[0]) {
                while (lo <= hi) {
                    mid = lo + (hi - lo) / 2;
                    if (nums[mid] > target) {
                        hi = mid - 1;
                    } else if (nums[mid] < target) {

                        if (nums[mid] < nums[0]) {
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    } else {
                        return mid;
                    }
                }
            } else if (target <= nums[lastIndex]) {
                while (lo <= hi) {
                    mid = lo + (hi - lo) / 2;
                    if (nums[mid] > target) {
                        if (nums[mid] >= nums[0]) {
                            lo = mid + 1;
                        }else{
                            hi = mid - 1;
                        }
                    } else if (nums[mid] < target) {
                        lo = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        } else {
            while (lo <= hi) {
                mid = lo + (hi - lo) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int nums[] = {3,1};
        int target = 1;
        int expect = 1;
        int res = search(nums, target);
        Assert.assertEquals(expect, res);

    }
}
