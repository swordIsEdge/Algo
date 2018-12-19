package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 21:50
 **/

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int index = 1;
        int i;
        for (i = 1; index < len; i++) {
            nums[i] = nums[index];
            if (nums[i] == nums[i - 1]) {
                for (; index < len; index++) {
                    if (nums[index] != nums[i]) {
                        break;
                    }
                }
            } else {
                index++;
            }
        }
        return i;
    }
    public static void main(String... args){
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i]);
            System.out.print(", ");
        }
    }

}
