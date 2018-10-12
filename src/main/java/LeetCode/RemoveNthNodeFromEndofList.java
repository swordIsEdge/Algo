package LeetCode;

import dataStructure.ConstructListNode;
import dataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 1) {
            return null;
        }

        ListNode temp = head;
        //temp先走n-1步
        for (int i = 1; i <= n - 1; i++) {
            temp = temp.next;
            if (temp == null) {
                return null;
            }
        }

        ListNode target = head;
        ListNode old = null;
        while (temp.next != null) {
            old = target;
            temp = temp.next;
            target = target.next;
        }

        //解除链接,单链表,把old指向target.next
        if (target == null) {
            return null;
        }
        ListNode tgNext = target.next;

        //old为空，说明target是第一个节点，直接返回target.next

        if (old==null){
            return tgNext;
        }

        old.next = tgNext;
        return head;
    }

    @Test
    public void test() {
        ListNode root = ConstructListNode.constructListNode(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        ListNode resu = removeNthFromEnd(root, n);
        ListNode expect = ConstructListNode.constructListNode(new int[]{1, 2, 3, 5});
        assertEquals(resu, expect);

    }
}
