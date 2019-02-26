package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 10:42
 **/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode nextNode;
        ListNode tmp = head;
        while (tmp!=null) {
            nextNode = tmp.next;
            if (nextNode == null) {
                break;
            }

            if (nextNode.val == val) {
                tmp.next = nextNode.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
