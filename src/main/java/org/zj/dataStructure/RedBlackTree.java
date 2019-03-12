package org.zj.dataStructure;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 10:00
 **/

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public void put(int k, int v) {
        root = put(root, k, v);
        root.color = BLACK;
    }

    private Node put(Node h, int k, int v) {
        if (h == null) {
            return new Node(k, v, 1, RED);
        }
        int cmp = k - h.key;

        if (cmp < 0) {
            h.left = put(h.left, k, v);

        } else if (cmp > 0) {
            h.right = put(h.right, k, v);
        } else {
            h.value = v;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = 1 + size(h.left) + size(h.right);
        return h;

    }

    private int size(Node h) {
        return h.size();
    }
    Node rotateLeft(Node h) {
        //出现红色右连接
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        h.color = h.color;
        x.color = RED;

        x.N = h.N;
        h.N = 1 + h.left.size() + h.right.size();

        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + h.left.size() + h.right.size();



        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private boolean isRed(Node h) {
        if (h == null) {
            return false;
        }
        return h.color == RED;
    }

    private class Node {
        int key;
        int value;
        Node left;
        Node right;
        int N; //这棵子数中的节点总数
        boolean color;

        public Node(int key, int value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
        public int size() {
            return N;
        }
    }


}
