package org.zj.LeetCode;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 15:27
 **/

public class PathSum {
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target &&root.left == null && root.right == null) {
                return true;
        }
        return hasPathSum(root.right, target - root.val) || hasPathSum(root.left, target - root.val);
    }

}
