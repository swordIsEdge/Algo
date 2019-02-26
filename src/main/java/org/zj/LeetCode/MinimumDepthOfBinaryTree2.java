package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 15:39
 **/

public class MinimumDepthOfBinaryTree2 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minLeft=Integer.MAX_VALUE, minRight=Integer.MAX_VALUE;

        if (root.left != null) {
            minLeft = minDepth(root.left);
        }
        if (root.right != null) {
            minRight = minDepth(root.right);
        }
        return 1 + Integer.min(minLeft, minRight);

    }
}
