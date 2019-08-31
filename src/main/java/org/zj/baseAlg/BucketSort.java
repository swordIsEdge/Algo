package org.zj.baseAlg;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-14 15:54
 **/

public class BucketSort {
    int maximumGap(int[] nums){
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(num,min);
            max = Math.max(max, num);
        }
        return -1;




    }
}









class Bucket{
    boolean used = false;
    int minVal = Integer.MAX_VALUE;
    int maxVal = Integer.MIN_VALUE;
}