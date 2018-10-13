package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        TwoStack stack = new TwoStack();
        while (true) {
            try {
                stack.push(head);
                head = head.next;
                stack.push(head);
                head = head.next;
                temp.next = stack.poll();
                temp = temp.next;
                temp.next = stack.poll();
                temp = temp.next;
            } catch (EndofNodesException e) {
                if (!stack.isEmpty()) {
                    temp.next = stack.poll();
                    temp = temp.next;
                }
                temp.next = null;
                return preHead.next;
            }
        }


    }

    class TwoStack {
        ListNode[] data = new ListNode[2];
        int size = 0;

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(ListNode node) throws EndofNodesException {
            if (size == 2) {
                throw new NullPointerException("stack is full");
            }
            if (node == null) {
                throw new EndofNodesException();
            }
            data[size++] = node;
        }

        public ListNode poll() {
            if (isEmpty()) {
                throw new NullPointerException("no element to poll");
            }
            return data[--size];

        }
    }

    class EndofNodesException extends Exception {

    }

    @Test
    public void test() {
        ListNode para = ConstructListNode.constructListNode(new int[]{1, 2, 3, 4});
        ListNode expect = ConstructListNode.constructListNode(new int[]{2, 1, 4, 3});
        ListNode res = swapPairs(para);
        Assert.assertEquals(expect, res);

    }
}
