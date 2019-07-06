package org.zj.LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length<2){
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        for (int i:nums) {
            if (i == target) {
                return true;
            }
        }
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        Set<Integer> nextSet = new HashSet<>();
        for (int i : nums) {
            nextSet.add(i);
            for (Integer integer : set) {
                int nextStep = integer+i;
                if(nextStep == target){
                    return true;
                }
                nextSet.add(nextStep);
            }
            set.addAll(nextSet);
            nextSet.clear();
        }
        return set.contains(target);

    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        boolean res = new PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(res);
    }
}
