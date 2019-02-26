package org.zj.LeetCode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 18:16
 **/

public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> realStack,minValue;
    public MinStack() {
        realStack = new Stack<>();
        minValue = new Stack<>();

    }

    public void push(int x) {
        realStack.push(x);
        if (minValue.isEmpty()) {
            minValue.push(x);
        }else {
        minValue.push(Math.min(minValue.peek(), x));}
    }

    public void pop() {
        minValue.pop();
        realStack.pop();

    }

    public int top() {
        return realStack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}
