package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 12:15
 **/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        //先检查是否是首尾
        //然后二分搜索满足 nums[i-1] < target < nums[i]的i即可
        if (nums == null || nums.length == 0 || target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int lo = 0, hi = nums.length - 1, mid = lo + (hi - lo) / 2;
        while (lo < hi) {
            int tmp = nums[mid];
            if (tmp < target) {
                lo = mid + 1;
            } else if (nums[mid - 1] < target) {
                return mid;
            } else {
                // nums[mid-1]>target
                hi = mid - 1;
            }
            mid = lo + (hi - lo) / 2;
        }
        return mid;
    }
    public static void main(String... args){
        int target = 5;
        int[] nums = {1, 3, 5, 6};
        int res = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(res);

    }
}
