package org.zj.LeetCode;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 14:21
 **/

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> lowerLimit = new LinkedList<>();
        LinkedList<Integer> upperLimit = new LinkedList<>();
        stack.add(root);
        lowerLimit.add(null);
        upperLimit.add(null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer low = lowerLimit.poll();
            Integer up = upperLimit.poll();

            if (node.left != null) {
                if (node.left.val < node.val) {
                    if (low != null && node.left.val <= low) {
                        return false;
                    }
                    stack.add(node.left);
                    upperLimit.add(node.val);
                    lowerLimit.add(low);
                } else {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.val < node.right.val) {
                    if (up != null && node.right.val >= up) {
                        return false;
                    }
                    stack.add(node.right);
                    lowerLimit.add(node.val);
                    upperLimit.add(up);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String... args){
        TreeNode node = ConstrucTreeNode.construct(new int[]{10,5,15,-1,-1,6,20});
        boolean res = new ValidateBinarySearchTree().isValidBST(node);
        System.out.println(res);
    }
}
