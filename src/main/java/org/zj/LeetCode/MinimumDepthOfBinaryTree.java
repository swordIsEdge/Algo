package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        System.out.println(new MinimumDepthOfBinaryTree().run(root));

    }

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return miniLen(root);
    }

    private int miniLen(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return miniLen(root.right) + 1;
        } else if (root.right == null) {
            return miniLen(root.left) + 1;
        } else {
            return Math.min(miniLen(root.left), miniLen(root.right)) + 1;
        }
    }
}
