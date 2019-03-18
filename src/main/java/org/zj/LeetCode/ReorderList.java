package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 18:17
 **/

public class ReorderList {
    public void reorderList3(ListNode head) {
        if (head == null || head.next == null)
            return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the slot of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public void reorderList2(ListNode head) {
    if(head==null||head.next==null) return;

    //Find the middle of the list
    ListNode p1=head;
    ListNode p2=head;
    while(p2.next!=null&&p2.next.next!=null){
        p1=p1.next;
        p2=p2.next.next;
    }

    //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
    ListNode preMiddle=p1;
    ListNode preCurrent=p1.next;
    while(preCurrent.next!=null){
        ListNode current=preCurrent.next;
        preCurrent.next=current.next;
        current.next=preMiddle.next;
        preMiddle.next=current;
    }

    //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
    p1=head;
    p2=preMiddle.next;
    while(p1!=preMiddle){
        preMiddle.next=p2.next;
        p2.next=p1.next;
        p1.next=p2;
        p1=p2.next;
        p2=preMiddle.next;
    }
}
    public void reorderList1(ListNode head) {
        if (head==null||head.next==null) return;
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode ptr=head;
        while (ptr!=null) {
            stack.push(ptr); ptr=ptr.next;
        }
        int cnt=(stack.size()-1)/2;
        ptr=head;
        while (cnt-->0) {
            ListNode top = stack.pop();
            ListNode tmp = ptr.next;
            ptr.next=top;
            top.next=tmp;
            ptr=tmp;
        }
        stack.pop().next=null;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;

        while (slow != null) {

            stack.push(slow);
            tmp = slow;
            slow = slow.next;
            tmp.next = null;
        }
        ListNode leftPointer = head.next;
        tmp = head;

        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;

            if (leftPointer == null) {
                break;
            }
            tmp.next = leftPointer;
            tmp = tmp.next;
            leftPointer = leftPointer.next;
        }

    }
    public static void main(String... args){
        ListNode head = ConstructListNode.constructListNode(new int[]{1, 2, 3, 4, 5,6});
        new ReorderList().reorderList2(head);
        System.out.println(head);

    }
}
