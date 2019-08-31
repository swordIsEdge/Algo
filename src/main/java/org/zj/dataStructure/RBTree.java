package org.zj.dataStructure;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-21 14:04
 **/

public class RBTree<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;//这棵子树中的节点总数
        boolean color;

        public Node(Key key, Value val, int n,boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }

    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }
}

