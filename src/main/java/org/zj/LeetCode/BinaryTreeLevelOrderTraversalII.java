package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;
import org.zj.dataStructure.TreeNode;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 16:44
 **/

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> tmp = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        tmp.push(root);

        while (!tmp.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();

            for (TreeNode treeNode : tmp) {
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
                list.add(treeNode.val);
            }
            stack.push(list);
            tmp = next;
            next = new LinkedList<>();
        }


        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;

    }
}
