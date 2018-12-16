package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 19:02
 **/

public class CombinationSumII {
    HashSet<List<Integer>> res = new HashSet<>();

    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        core(new ArrayList<Integer>(), 0, target);
        return new ArrayList<>(res);
    }

    private void core(ArrayList<Integer> list, int start, int temTgt) {
        for (int i = start ; i < candidates.length; i++) {
            if (candidates[i] < temTgt) {
                list.add(candidates[i]);
                core(list, i+1, temTgt - candidates[i]);
                list.remove(list.size() - 1);
            } else if (candidates[i] == temTgt) {
                list.add(candidates[i]);
                res.add((List<Integer>) list.clone());
                list.remove(list.size() - 1);
                return;
            } else {
                break;
            }
        }
    }
    public static void main(String... args){
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int tgt = 8;
        new CombinationSumII().combinationSum2(nums, tgt);
    }
}
