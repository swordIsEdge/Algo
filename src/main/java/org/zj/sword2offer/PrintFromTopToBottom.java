package org.zj.sword2offer;

import org.zj.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                result.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return result;

    }

}
