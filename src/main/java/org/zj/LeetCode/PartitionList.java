package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 14:02
 **/

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1), lessPointer = less;
        ListNode greatOrEqual = new ListNode(-1), gOEPointer = greatOrEqual;
        while (head != null) {
            if (head.val < x) {
                //接到less
                lessPointer.next = head;
                lessPointer = lessPointer.next;
            } else {
                //接到goe
                gOEPointer.next = head;
                gOEPointer = gOEPointer.next;
            }
            head = head.next;
            lessPointer.next = null;
            gOEPointer.next = null;
        }
        less = less.next;
        greatOrEqual = greatOrEqual.next;
        if (less == null) {
            return greatOrEqual;
        }
        lessPointer.next = greatOrEqual;
        return less;
    }

    public static void main(String... args){
        ListNode listNode = ConstructListNode.constructListNode(new int[]{1, 4, 3, 2, 5, 2});
        ListNode result = new PartitionList().partition(listNode, 3);
        System.out.print(result);

    }
}
