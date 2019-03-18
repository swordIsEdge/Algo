package org.zj.LeetCode;

public class MaximumProductSubarray {
    public static void main(String... args) {
        new MaximumProductSubarray().maxProduct(new int[]{0,2});
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] postive = new int[len];
        int[] negtive = new int[len];
        postive[0] = nums[0] >= 0 ? nums[0] : 0;
        negtive[0] = nums[0] <= 0 ? nums[0] : 0;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            if (tmp == 0) {
                postive[i] = negtive[i] = 0;
            } else if (tmp < 0) {
                postive[i] = negtive[i - 1] == 0 ? 0 : negtive[i - 1] * tmp;
                negtive[i] = postive[i - 1] == 0 ? tmp: postive[i - 1] * tmp;
            } else {
                postive[i] = postive[i - 1] == 0 ? tmp : postive[i - 1] * tmp;
                negtive[i] = negtive[i - 1] == 0 ? 0 : negtive[i - 1] * tmp;
            }

            max = Math.max(max, postive[i]);
        }
        return max;
    }
}
