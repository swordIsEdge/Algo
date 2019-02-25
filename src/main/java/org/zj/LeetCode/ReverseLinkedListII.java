package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 12:45
 **/

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        ListNode orderTail = preHead;
        for (int i = 0; i < m - 1; i++) {
            orderTail.next = head;
            orderTail = orderTail.next;
            head = head.next;
        }
        ListNode rTail = head;
        ListNode last = head;
        ListNode rHead = null;
        head = head.next;
        rHead = head.next;
        for (int i = m; i < n; i++) {
            rHead = head;
            head = head.next;
            rHead.next = last;
            last = rHead;
        }
        rTail.next = head;
        orderTail.next = rHead;
        return preHead.next;

    }
    public static void main(String... args){
        ListNode head = ConstructListNode.constructListNode(new int[]{1, 2, 3, 4, 5});
        ListNode nhead = new ReverseLinkedListII().reverseBetween(head, 1, 5);
        System.out.println(nhead);

    }
}
