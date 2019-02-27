package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 21:03
 **/

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        return null;
    }

    public int getIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i < end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
