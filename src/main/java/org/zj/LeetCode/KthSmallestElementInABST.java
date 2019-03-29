package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-24 13:19
 **/

public class KthSmallestElementInABST {
    Integer res;
    public int kthSmallest(TreeNode root, int k) {
        res = null;
        core(root, k, 0);
        return res;
    }

    private int core(TreeNode root, int k, int start) {
        if (res != null) {
            return -1;
        }
        if (root == null) {
            return start;
        }

        int last = core(root.left, k, start);
        if (last + 1 == k) {
            res = root.val;
        }
        last = core(root.right, k, last + 1);
        return last;

    }
}
