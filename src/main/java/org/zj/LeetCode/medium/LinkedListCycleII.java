package org.zj.LeetCode.medium;

import org.zj.dataStructure.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null||head.next.next==null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }

        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        ListNode newHead = head;
        while (newHead != slow) {
            newHead = newHead.next;
            slow = slow.next;
        }
        return slow;

    }
}
