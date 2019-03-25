package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

public class FlattenBinaryTreetoLinkedList2 {
    TreeNode pre ;
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode preLeft = root.left;
        TreeNode preRight = root.right;

        pre = root;
        pre.left = null;
        pre.right = null;
        core(preLeft);
        core(preRight);
    }

    public void core(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode tmpLeft = cur.left;
        TreeNode tmpRight = cur.right;
        pre.right = cur;
        pre = cur;
        pre.left = null;
        pre.right = null;
        core(tmpLeft);
        core(tmpRight);
    }
}
