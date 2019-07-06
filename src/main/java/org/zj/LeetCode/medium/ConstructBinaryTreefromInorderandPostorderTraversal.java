package org.zj.LeetCode.medium;

import org.zj.dataStructure.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        int len2 = postorder.length;
        if (len != len2) {
            return null;
        }
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            TreeNode root = new TreeNode(inorder[inEnd]);
            return root;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = search(inorder, inStart, inEnd, postorder[postEnd]);
        int leftLength = index - inStart;
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + leftLength - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + leftLength , postEnd - 1);
        return root;

    }

    private int search(int[] data, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
