package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algo
 * @description:77题的递归改循环版本
 * @author: kasumi
 * @create: 2018-12-18 20:12
 **/

public class CombinationsLoopVersion {
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

    public static void main(String... args) {
        int n = 3;
        int k = 2;
        List<List<Integer>> res = new CombinationsLoopVersion().combine(n, k);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
                System.out.print(", ");
            }
            System.out.println();

        }
    }


}








