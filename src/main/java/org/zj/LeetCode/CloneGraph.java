package org.zj.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-28 11:04
 **/

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        Node tmp;
        while (!stack.empty()) {

        }
        return null;

    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};