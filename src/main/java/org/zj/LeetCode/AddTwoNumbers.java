package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

/**
 * Author:kasumi
 * Date:2018/9/25
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode d = head;
        int carry = 0, v1 = 0, v2 = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {

            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + carry;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
            d.next = new ListNode(sum % 10);
            d = d.next;
            carry = sum / 10;

        }
        return head.next;
    }
    public static void main(String... args){
        ListNode l1 = ConstructListNode.constructListNode(new int[]{2, 4, 3});
        ListNode l2 = ConstructListNode.constructListNode(new int[]{5, 6, 4});
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
}
