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

    public static void main(String... args){
        TreeNode root = ConstrucTreeNode.construct(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int max = new BinaryTreeMaximumPathSum().maxPathSum(root);
        System.out.println(max);

    }



    int max ;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        core(root, max);
        return max;
    }

    private int core(TreeNode root, int tmpLength) {

        if (root == null) {
            max = Math.max(max, tmpLength);
            return 0;
        }

        tmpLength = tmpLength < 0 ? root.val : (tmpLength + root.val);
        max = Math.max(max, tmpLength);

        if (root.left == null && root.right == null) {
            max = Math.max(max, tmpLength);
            return root.val;
        }
        int leftMax = core(root.left, tmpLength) + root.val;
        int rightMax = core(root.right, Math.max(tmpLength, leftMax)) + root.val;


        return Math.max(leftMax, rightMax);
    }
}
