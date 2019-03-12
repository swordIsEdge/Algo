package org.zj.test;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 14:36
 **/

public class StackWithMin {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        min.push(min.isEmpty()?node:Math.min(data.peek(), min.peek()));
    }

    public void pop() {
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
