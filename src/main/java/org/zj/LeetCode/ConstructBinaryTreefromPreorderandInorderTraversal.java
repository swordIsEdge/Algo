package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.Arrays;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 20:42
 **/

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int head = preorder[preStart];
        TreeNode root = new TreeNode(head);

        int headIndex = getIndex(inorder, inStart, inEnd, head);
        int leftCounts = headIndex - inStart;
        int rightCounts = inEnd - headIndex;
        root.left = buildTree(preorder, preStart + 1, preStart + leftCounts , inorder, inStart,headIndex-1 );
        root.right = buildTree(preorder, preStart + leftCounts+1, preEnd, inorder, headIndex + 1, inEnd);
        return root;
    }

    private int getIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;

            }
        }
        return -1;
    }
    public static void main(String... args){
        ConstructBinaryTreefromPreorderandInorderTraversal test = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] pre = {1,2};
        int[] in = {2,1};
        TreeNode root = test.buildTree(pre, in);
    }
}
