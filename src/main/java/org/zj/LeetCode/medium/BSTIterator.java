package org.zj.LeetCode.medium;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-07 18:01
 **/


public class BSTIterator {
    private TreeNode next;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        next = root;
        this.stack = new Stack<>();
        if (next == null) {
            return;
        }
        while (next.left != null) {
            stack.push(next);
            next = next.left;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode lastNext = next;
        if (next.right != null) {
            //doSth
            next = next.right;
            while (next.left != null) {
                stack.push(next);
                next = next.left;
            }

        } else if (stack.isEmpty()) {
            next = null;
        } else {
            next = stack.pop();
        }


        return lastNext.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !(next == null && stack.empty());
    }

    public static void main(String... args) {
        Integer[] nums = {7, 3, 15, null, null, 9, 20};
        TreeNode root = ConstrucTreeNode.construct(nums);
        BSTIterator obj = new BSTIterator(root);
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }
}
