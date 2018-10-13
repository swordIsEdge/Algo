package org.zj.sword2offer;

import java.util.Stack;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (minData.empty()) {
            minData.push(node);
        } else {
            minData.push(Math.min(node, minData.peek()));
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }
}
