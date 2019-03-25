package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> tmp = new LinkedList<>();
        Queue<TreeNode> next;
        tmp.add(root);
        while (!tmp.isEmpty()) {
            res.add(tmp.peek().val);
            next = new LinkedList<>();
            while (!tmp.isEmpty()) {
                TreeNode cur = tmp.poll();
                if (cur.right != null) {
                    next.add(cur.right);
                }
                if (cur.left != null) {
                    next.add(cur.left);
                }
            }
            tmp = next;
        }
        return res;




    }
}
