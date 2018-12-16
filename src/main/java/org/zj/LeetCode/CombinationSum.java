package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 15:58
 **/

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        core(new ArrayList<Integer>(), 0,target);
        return res;
    }

    private void core(ArrayList<Integer> list, int start, int temTgt) {
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < temTgt) {
                list.add(candidates[i]);
                core(list, i,temTgt - candidates[i]);
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
}














