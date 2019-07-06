package org.zj.LeetCode.hard;

import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {
        String s = "[]";
        TreeNode node = new SerializeandDeserializeBinaryTree().deserialize(s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        final char sep = ',';
        final String nullNode = "null";

        queue.add(root);
        sb.append('[');

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (Objects.isNull(tmp)) {
                sb.append(nullNode);
            } else {
                sb.append(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);

            }
            sb.append(sep);
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        String[] nodesInString = data.substring(1, data.length() - 1).split(",");
        int idx = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue;
        TreeNode root = new TreeNode(Integer.parseInt(nodesInString[idx++]));
        queue.add(root);
        while (idx < nodesInString.length) {
            nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                tmp.left = geneTN(nodesInString[idx++]);
                if (tmp.left != null) {
                    nextQueue.add(tmp.left);
                }
                tmp.right = geneTN(nodesInString[idx++]);
                if (tmp.right != null) {
                    nextQueue.add(tmp.right);
                }
            }
            queue = nextQueue;
        }
        return root;

    }

    private TreeNode geneTN(String s) {
        if (s.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }


}
