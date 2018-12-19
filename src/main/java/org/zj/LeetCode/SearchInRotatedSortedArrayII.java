package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 22:18
 **/

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = nums[0];
        int right = nums[nums.length - 1];
        if (left == right) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
        if (target == left || target == right) {
            return true;
        }
        if (left > right) {
            //存在旋转现象
            if (right < target && target < left) {
                return false;
            }
            if (target > left) {
                //存在于左半部分
                int lo = 0, hi = nums.length - 1, mid = lo + (hi - lo) / 2;
                while (lo <= hi) {
                    int tmp = nums[mid];
                    if (tmp < left) {
                        hi = mid - 1;
                    } else if (target < tmp) {
                        hi = mid - 1;
                    } else if (tmp < target) {
                        lo = mid + 1;
                    } else {
                        return true;
                    }
                    mid = lo + (hi - lo) / 2;

                }
                return false;


            } else {
                // 存在于右半部分

                int lo = 0, hi = nums.length - 1, mid = lo + (hi - lo) / 2;
                while (lo <= hi) {
                    int tmp = nums[mid];
                    if (tmp > right) {
                        lo = mid + 1;
                    } else if (target < tmp) {
                        hi = mid - 1;
                    } else if (tmp < target) {
                        lo = mid + 1;
                    } else {
                        return true;
                    }
                    mid = lo + (hi - lo) / 2;

                }
                return false;

            }


        } else {
            //没有旋转，直接二分
            int lo = 0, hi = nums.length - 1;
            int mid = lo + (hi - lo) / 2;
            while (lo <= hi) {
                int tmp = nums[mid];
                if (tmp == target) {
                    return true;
                }
                if (target < tmp) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
                mid = lo + (hi - lo) / 2;
            }
            return false;
        }
    }

    public static void main(String... args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 2;
        boolean result = new SearchInRotatedSortedArrayII().search(nums, target);
        System.out.println(result);
    }
}
