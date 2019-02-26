package org.zj.LeetCode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 13:39
 **/

public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> core,helper;

        /** Initialize your data structure here. */
        public MyQueue() {
            core = new Stack<>();
            helper = new Stack<>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!core.empty()) {
                helper.push(core.pop());
            }
            helper.push(x);
            while (!helper.empty()) {
                core.push(helper.pop());
            }

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return core.pop();
        }

        /** Get the front element. */
        public int peek() {
            return core.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return core.empty();

        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
