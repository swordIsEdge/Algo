package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;

import java.util.HashMap;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 13:58
 **/
//尝试使用快慢指针法
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }

        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }
}
