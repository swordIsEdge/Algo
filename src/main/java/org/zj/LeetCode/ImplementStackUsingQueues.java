package org.zj.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 12:41
 **/

public class ImplementStackUsingQueues {

    class MyStack {
        Queue<Integer> objects,helper,tmp;
        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            objects = new LinkedList<>();
            helper = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            helper.add(x);
            helper.addAll(objects);

            tmp = objects;
            tmp.clear();
            objects = helper;
            helper = tmp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return objects.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return objects.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return objects.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}