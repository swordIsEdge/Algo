package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 09:47
 **/

public class FlattenBinaryTreetoLinkedList {
    Queue<TreeNode> queue;
    public void flatten(TreeNode root) {
        queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        core(root.left);
        core(root.right);
        TreeNode tmp = root;
        while (!queue.isEmpty()) {
            tmp.right = queue.peek();
            tmp.left = null;
            tmp = queue.poll();
        }


    }

    private void core(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        core(root.left);
        core(root.right);

    }
}
