package sword2offer;

import dataStructure.ListNode;
/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = null,
                orderHead = head,
                orderPointer = head.next;
        while (orderPointer.next != null) {
            orderHead.next = reverseHead;
            reverseHead = orderHead;
            orderHead = orderPointer;
            orderPointer = orderPointer.next;
        }
        orderHead.next = reverseHead;
        orderPointer.next = orderHead;
        return orderPointer;


    }
}
