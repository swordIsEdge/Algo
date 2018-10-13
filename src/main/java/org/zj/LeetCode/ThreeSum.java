package org.zj.LeetCode;

import java.util.*;

public class ThreeSum {
    public static void main(String... args) {
        List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + ", ");
            }
            System.out.println("********************");

        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int want = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < want) {
                    j++;
                } else if (sum > want) {
                    k--;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                }
            }

        }
        return new ArrayList<>(result);
    }
}
