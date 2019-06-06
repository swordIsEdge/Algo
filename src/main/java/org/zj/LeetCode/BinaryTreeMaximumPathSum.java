package org.zj.LeetCode;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-25 12:32
 **/

public class BinaryTreeMaximumPathSum {

    public static void main(String... args) {
        TreeNode root = ConstrucTreeNode.construct(new Integer[]{1,-2,-3,1,3,-2,null,-1});
        int max = new BinaryTreeMaximumPathSum().maxPathSum(root);
        System.out.println(max);

    }


    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        core(root);
        return max;
    }

    private int core(TreeNode root) {
        int tmpMax = 0;
        if (root == null) {
            tmpMax = Integer.MIN_VALUE;
        } else if (root.left == null && root.right == null) {
            tmpMax = root.val;
        } else {
            int leftMax = core(root.left);
            int rightMax = core(root.right);
            int maxChild = Math.max(leftMax, rightMax);
            tmpMax = root.val + (maxChild > 0 ? maxChild : 0);
            int tmpThis = root.val+(leftMax>0?leftMax:0)+(rightMax>0?rightMax:0);
            max = Math.max(max,tmpThis);

        }
        max = Math.max(max, tmpMax);
        return tmpMax;

    }
}
