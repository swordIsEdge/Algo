package org.zj.LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String... args){
        int a = new ThreeSumClosest().threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(a);

    }
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = target;

        int def = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            int want = target - nums[i];
            while (lo < hi) {
                int tempSum = nums[lo] + nums[hi];
                if (Math.abs(want - tempSum) < def) {
                    def = Math.abs(want - tempSum);
                    res = tempSum + nums[i];
                }
                if (tempSum < want) {
                    lo++;
                } else if (tempSum > want) {
                    hi--;
                } else {
                    return target;
                }

           }
        }
        return res;


    }

}
