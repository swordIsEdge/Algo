package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 13:04
 **/

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int reach = 0;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            tmp = nums[i] + i;
            reach = Math.max(tmp, reach);
            if (reach >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String... args){
        int[] nums = {2,0,0};
        boolean res = new JumpGame().canJump(nums);
        System.out.println(res);
    }
}
