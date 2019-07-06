package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 21:57
 **/

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        Integer lastVal = null;
        while (head.next != null) {
            if (head.val == head.next.val) {
                lastVal = head.val;
                head = head.next;
                continue;
            }
            if (lastVal != null && lastVal == head.val) {
                head = head.next;
                continue;
            }
            tmp.next = head;
            tmp = tmp.next;
            head = head.next;
            tmp.next = null;
        }
        if (lastVal != null && lastVal == head.val) {
            return result.next;
        }
        tmp.next = head;
        return result.next;
    }

    public static void main(String... args) {
        ListNode head = ConstructListNode.constructListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        System.out.println(result);

    }
}
