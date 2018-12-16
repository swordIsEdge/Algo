package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 20:29
 **/

public class PermutationsII {
    Set<List<Integer>> res = new HashSet<>();
    boolean[] contain;
    int[] nums;
    int target;
    public List<List<Integer>> permuteUnique(int[] nums) {
        contain = new boolean[nums.length];
        for (int i = 0; i < target; i++) {
            contain[i] = false;
        }
        int count = 0;
        this.nums = nums;
        this.target = nums.length;
        core(new ArrayList<>(), count);
        return new ArrayList<>(res);

    }
    private void core(ArrayList<Integer> list,int count) {
        if (count == target) {
            res.add((List<Integer>) list.clone());
            return;
        }
        for (int i = 0; i < target; i++) {
            if (!contain[i]) {
                list.add(nums[i]);
                contain[i] = true;
                core(list, count + 1);
                contain[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
