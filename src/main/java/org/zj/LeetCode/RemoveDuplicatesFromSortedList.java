package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 13:30
 **/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head;

        ListNode last = head;
        ListNode next = last.next;
        last.next = null;
        while (next != null) {
            if (next.val == last.val) {
                next = next.next;
            } else {
                last.next = next;
                next = next.next;
                last = last.next;
                last.next = null;
            }
        }
        return result;
    }
    public static void main(String... args){
        ListNode head = ConstructListNode.constructListNode(new int[]{1, 1,2});
        System.out.println(head);
        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        System.out.println(result);

    }
}
