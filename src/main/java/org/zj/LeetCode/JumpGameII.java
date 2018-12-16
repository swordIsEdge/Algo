package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 19:36
 **/

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 0 || (nums.length == 1 )) {
            return 0;
        }
        int target = nums.length-1;
        if (nums[0] >= target) {
            return 1;
        }
        int i;
        boolean connect = false;
        int steps = 0;
        int lastCoverage = -1, thisCoverage = nums[0];
        for (i = 0; i <=target ; i++) {
            if (i > lastCoverage) {
                steps++;
                lastCoverage = thisCoverage;
            }
            int tmp = i + nums[i];
            if (tmp >= target) {
                connect = true;
                steps++;
                break;
            }
            if (tmp > thisCoverage) {
                thisCoverage = tmp;
            }

        }

        if (!connect) {
            return 0;
        }

        return steps;
    }
    public static void main(String... args){
        int[] nums = {2, 3, 1, 1, 4};
        int res = new JumpGameII().jump(nums);
        System.out.println(res);

    }
}
