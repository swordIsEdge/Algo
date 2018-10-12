package sword2offer;

import java.util.Stack;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class TwoStackAsQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);

    }

    public int pop() {
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();

    }
}
