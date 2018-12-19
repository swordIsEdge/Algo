package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 19:18
 **/

public class Combinations {
    int n;
    int k;
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.result = new ArrayList<>();

        if (k == 0 || n < k) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(i);
        }
        core(0, 1, res);
        return result;
    }


    private void core(int size, int start, ArrayList<Integer> list) {
        if (size == k) {
            result.add((List<Integer>) list.clone());
            return;
        }
        int end = n - k + size + 1;
        for (int i = start; i <= end; i++) {
            list.set(size, i);
            core(size + 1, i + 1, list);
        }
    }
    public static void main(String... args) {
        int n = 6;
        int k = 3;
        List<List<Integer>> res = new Combinations().combine(n, k);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
                System.out.print(", ");
            }
            System.out.println();

        }
    }
}
