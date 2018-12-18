package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 15:43
 **/

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null ) {

            return head;
        }

        ListNode tail = head;

        //先算出长度
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode tmp = head;
        for (int i = 0; i < len-k-1; i++) {
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;

        tmp.next = null;
        tail.next = head;
        return newHead;

    }
    public static void main(String... args){
        ListNode head = ConstructListNode.constructListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        int k = 3;
        ListNode res = new RotateList().rotateRight(head, k);
        System.out.print(res);

    }
}
