package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 20:34
 **/

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> temp,next;
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        temp = new LinkedList<>();
        next = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {
            List<Integer> line = new ArrayList<>();

            for (TreeNode treeNode : temp) {
                line.add(treeNode.val);
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            res.add(line);
            temp = next;
            next = new LinkedList<>();
        }

        return res;








    }
}
