package org.zj.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class ConstrucTreeNode {
    public static void main(String... args) {
        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = construct(nodes);

        System.out.print(root.val);
    }

    public static TreeNode construct(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        if (nodes.length == 1) {
            return new TreeNode(nodes[0]);
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> result = new LinkedList<>();
        result.add(root);
        for (int i = 1; i < nodes.length; ) {
            TreeNode tmp = result.poll();

            if (nodes[i] == null) {
                tmp.left = null;
            } else {
                tmp.left = new TreeNode(nodes[i]);
                result.add(tmp.left);
            }

            i++;
            if (i == nodes.length) {
                break;
            }
            if (nodes[i] == null) {
                tmp.right = null;
            } else {
                tmp.right = new TreeNode(nodes[i]);
                result.add(tmp.right);
            }
            i++;

        }
        return root;

    }
}
