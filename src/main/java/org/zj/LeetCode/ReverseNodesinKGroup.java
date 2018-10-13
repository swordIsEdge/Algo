package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.zj.dataStructure.ConstructListNode.constructListNode;

public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        ListNodeStack stack = new ListNodeStack(k);
        {
            try {
                while (true) {
                    for (int i = 0; i < k; i++) {
                        stack.push(head);

                        head = head.next;
                    }
                    for (int i = 0; i < k; i++) {
                        temp.next = stack.poll();
                        temp = temp.next;

                    }
                }
            } catch (EndofNodesException e) {
                temp.next = stack.getFirst();

            } finally {
                return preHead.next;
            }
        }


    }

    class ListNodeStack {
        int capacity;
        ListNode[] data;
        int size;

        public ListNodeStack(int capacity) {
            this.capacity = capacity;
            data = new ListNode[capacity];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public ListNode getFirst() {
            if (!isEmpty()) {
                return data[0];
            }
            return null;

        }
        public void push(ListNode node) throws EndofNodesException {
            if (size == capacity) {
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
        ListNode para1 = constructListNode(new int[]{1, 2, 3, 4, 5});
        ListNode para2 = constructListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expect2 = constructListNode(new int[]{2, 1, 4, 3, 5});
        ListNode expect3 = constructListNode(new int[]{3, 2, 1, 4, 5});
        ListNode res2 = reverseKGroup(para1, 2);
        ListNode res3 = reverseKGroup(para2, 3);
        Assert.assertEquals(expect2, res2);
        Assert.assertEquals(expect3, res3);
    }


}
