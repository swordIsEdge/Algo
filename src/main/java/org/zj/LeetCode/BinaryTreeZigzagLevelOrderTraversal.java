package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-28 08:24
 **/

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> core = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        LinkedList<Integer> tmpLine;
        boolean rightStart = false;
        TreeNode tmpNode;

        core.add(root);

        while (!core.isEmpty()) {
            tmpLine = new LinkedList<>();
            while (!core.isEmpty()) {
                tmpNode = core.pop();
                tmpLine.add(tmpNode.val);
                if (rightStart) {
                    if (tmpNode.right != null) {
                        next.push(tmpNode.right);
                    }
                    if (tmpNode.left != null) {
                        next.push(tmpNode.left);
                    }
                } else {
                    if (tmpNode.left != null) {
                        next.push(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        next.push(tmpNode.right);
                    }
                }
            }
            result.add(tmpLine);

            core = next;
            next = new Stack<>();
            rightStart = !rightStart;
        }
        return result;




    }
}
