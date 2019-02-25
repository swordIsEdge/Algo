package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 12:21
 **/

public class SubsetsII {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n < k) {
            return new ArrayList<>();
        }

        int[] indexs = new int[k + 1];//记录所处的位置
        indexs[0] = 1;
        ArrayList<Integer> nums = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            nums.add(-1);
        }
        List<List<Integer>> result = new ArrayList<>();


        int size = 0;
        while (size >= 0) {
            int end = n - k + size + 1;
            if (size == k) {
                result.add((List<Integer>) nums.clone());
                size--;
                if (size >= 0) {
                    indexs[size]++;
                }
            } else if (indexs[size] > end) {
                size--;
                if (size >= 0) {
                    indexs[size]++;
                }
            } else {
                nums.set(size, indexs[size]);
                indexs[size + 1] = indexs[size] + 1;
                size++;
            }
        }
        return result;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> count;
        for (int k = 1; k <= n; k++) {
            count = combine(n, k);
            for (List<Integer> integers : count) {
                ArrayList<Integer> single = new ArrayList<>();
                for (Integer integer : integers) {
                    single.add(nums[integer - 1]);
                }
                result.add(single);
            }
        }
        return new ArrayList<>(result);
    }

}
