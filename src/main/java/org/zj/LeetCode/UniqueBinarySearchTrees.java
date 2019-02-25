package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 14:25
 **/

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
       long C = 1;
        for (int i = 1; i <n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) C;


    }
    public static void main(String... args){
        int n = 3;
        int res = new UniqueBinarySearchTrees().numTrees(n);
        System.out.println(res);
    }
}
