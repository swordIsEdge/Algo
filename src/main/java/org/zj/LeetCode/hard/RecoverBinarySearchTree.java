package org.zj.LeetCode.hard;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode pre = null;
    TreeNode[] target = new TreeNode[2];

    public void recoverTree(TreeNode root) {
        mid(root);
        int tmp = target[0].val;
        target[0].val = target[1].val;
        target[1].val = tmp;

    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);

        if (pre != null && pre.val > root.val) {
            if (target[0] == null) {
                target[0] = pre;
            }
            target[1] = root;

        }
        pre = root;

        mid(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = ConstrucTreeNode.construct(new Integer[]{3, 1, 4, null, null, 2});
        RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
        rbst.recoverTree(root);

    }
}
