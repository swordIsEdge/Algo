package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 14:57
 **/

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return core(1, n, n);
    }

    private List<TreeNode> core(int start, int end, int num) {
        List<TreeNode> res = new LinkedList<>();

        if (num == 0) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode treeNode = new TreeNode(start);
            res.add(treeNode);
            return res;
        }

        for (int i = 0; i < num; i++) {
            List<TreeNode> left = core(start, start + i - 1, i);
            List<TreeNode> right = core(start + i + 1, end, num - 1 - i);
            TreeNode root;
            for (TreeNode nr : right) {
                for (TreeNode nl : left) {
                    root = new TreeNode(start + i);
                    root.left = nl;
                    root.right = nr;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
