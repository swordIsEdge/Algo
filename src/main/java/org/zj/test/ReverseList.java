package org.zj.test;

import org.zj.dataStructure.ListNode;

import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 14:31
 **/

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmpTail = head;
        ListNode tmp = head.next;
        tmpTail.next = null;

        ListNode nextNode;

        while (tmp != null) {
            nextNode = tmp.next;
            tmp.next = tmpTail;
            tmpTail = tmp;
            tmp = nextNode;
        }
        return tmpTail;


    }

}
