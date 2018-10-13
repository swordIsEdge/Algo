package org.zj.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class TwoQueueAsStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private Queue<Integer> temp;

    public void push(int node) {
        queue1.add(node);
    }

    public int pop() {
        int result;
        if (queue1.size() < 1) {
            throw new RuntimeException();
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return queue2.poll();

    }
    public static void main(String... args){
        TwoQueueAsStack tw = new TwoQueueAsStack();
        tw.push(1);
        tw.push(2);
        tw.push(123);
        System.out.println(tw.pop());
        System.out.println(tw.pop());
        System.out.println(tw.pop());

    }
}
