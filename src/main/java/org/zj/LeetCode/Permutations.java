package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 20:15
 **/

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] contain;
    int[] nums;
    int target;

    public List<List<Integer>> permute(int[] nums) {
        contain = new boolean[nums.length];
        for (int i = 0; i < target; i++) {
            contain[i] = false;
        }
        int count = 0;
        this.nums = nums;
        this.target = nums.length;
        core(new ArrayList<>(), count);
        return res;

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
    public static void main(String... args){
        int[] nums = {1, 2, 3};
        new Permutations().permute(nums);
    }

}
