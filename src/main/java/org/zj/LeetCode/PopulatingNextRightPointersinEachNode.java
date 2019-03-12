package org.zj.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 09:30
 **/

 public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            for (int i = 1; i < count; i++) {
                Node tmp = queue.poll();
                if (tmp.left!=null) {
                    queue.add(tmp.left);
                    newCount++;
                }
                if (tmp.right!=null) {
                    queue.add(tmp.right);
                    newCount++;
                }
                tmp.next = queue.peek();
            }
            Node tmp = queue.poll();
            if (tmp.left!=null) {
                queue.add(tmp.left);
                newCount++;
            }
            if (tmp.right!=null) {
                queue.add(tmp.right);
                newCount++;
            }
            tmp.next = null;
            count =newCount;

        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
