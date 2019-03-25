package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String... args){
        int[] nums = {0,2,3,4,6,8,9};
        List<String> result = new SummaryRanges().summaryRanges(nums);
        result.forEach(System.out::println);
    }
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        if (len == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = nums[0];
        int startIndex = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                continue;
            } else {
                if (i == startIndex) {
                    result.add(String.valueOf(nums[i]));
                } else {
                    result.add(String.valueOf(start) + "->" + String.valueOf(nums[i]));
                }
                start = nums[i + 1];
                startIndex = i + 1;
            }
        }
        if (len-1 == startIndex) {
            result.add(String.valueOf(nums[len-1]));
        } else {
            result.add(String.valueOf(start) + "->" + String.valueOf(nums[len - 1]));
        }
        return result;

    }
}
