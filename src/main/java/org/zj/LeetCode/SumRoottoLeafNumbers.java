package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 09:13
 **/

public class SumRoottoLeafNumbers {
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0;

        core(root,0);
        return result;
    }

    private void core(TreeNode root,int temp) {
        if (root == null) {
            return;
        }
        temp = temp * 10 + root.val;

        if (root.left == null && root.right == null) {
            result += temp;
            return;
        }
        core(root.left,temp);
        core(root.right,temp);
    }
}
