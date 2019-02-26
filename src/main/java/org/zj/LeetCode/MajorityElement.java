package org.zj.LeetCode;

import java.util.Arrays;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 20:04
 **/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len <=2) {
            return nums[0];
        }
        Arrays.sort(nums);
        int mid = len / 2;
            return nums[mid];






    }
}
