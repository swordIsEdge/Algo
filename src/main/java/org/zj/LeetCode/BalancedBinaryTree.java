package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.regex.Matcher;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 16:36
 **/

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (core(root) == -1) {
            return false;
        }
        return true;
    }

    private int core(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lenL = core(root.left);
        int lenR = core(root.right);

        if (lenL == -1 || lenR == -1) {
            return -1;
        }

        if (Math.abs(lenL - lenR) > 1) {
            return -1;
        }
        return 1 + Math.max(lenL, lenR);

    }
}
