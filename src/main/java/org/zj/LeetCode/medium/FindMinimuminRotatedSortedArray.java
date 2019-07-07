package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 11:50
 **/

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[nums.length - 1] < nums[0]) {
            int flag = nums[0];
            int lo = 0, hi = nums.length - 1;
            while (true) {
                int mid = lo + ((hi - lo) >> 1);
                if (nums[mid] >= flag) {
                    lo = mid + 1;
                } else if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    hi = mid-1;
                }
            }
        } else {
            return nums[0];
        }


    }

    public static void main(String... args) {
        FindMinimuminRotatedSortedArray obj = new FindMinimuminRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int res = obj.findMin(nums);
        System.out.println(res);

    }
}
