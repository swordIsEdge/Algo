package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;

public class InsertionSortList {
    public static void main(String... args) {
        ListNode root = ListNode.getInstanceFromArray(new int[]{-1, 5, 3, 4, 0});
        new InsertionSortList().insertionSortList(root);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode disguiseHead = new ListNode(Integer.MIN_VALUE);
        disguiseHead.next = head;

        ListNode tmp = head.next;
        head.next = null;

        while (tmp != null) {
            ListNode tmpHead = disguiseHead;
            while (tmpHead.next != null && tmpHead.next.val < tmp.val) {
                tmpHead = tmpHead.next;
            }
            ListNode nextTmp = tmp.next;
            tmp.next = tmpHead.next;
            tmpHead.next = tmp;
            tmp = nextTmp;
        }
        return disguiseHead.next;
    }
}
