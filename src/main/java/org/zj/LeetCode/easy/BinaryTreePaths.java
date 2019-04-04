package org.zj.LeetCode.easy;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = ConstrucTreeNode.construct(new Integer[]{1, 2, 3, null, 5});
        new BinaryTreePaths().binaryTreePaths(root).forEach(System.out::println);


    }
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        core(root, sb);
        return result;
    }

    private void core(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(root.val);


        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            core(root.left, new StringBuilder(sb));
            core(root.right, new StringBuilder(sb));
        }
    }
}
