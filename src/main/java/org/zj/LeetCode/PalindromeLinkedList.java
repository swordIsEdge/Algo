package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 13:25
 **/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        int halfLen = len / 2;
        Stack<ListNode> stack = new Stack<>();
        tmp = head;
        for (int i = 0; i < halfLen; i++) {
            stack.add(tmp);
            tmp = tmp.next;
        }

        if (len % 2 == 1) {
            tmp = tmp.next;
        }

        ListNode older ;
        for (int i = 0; i < halfLen; i++) {
            older = stack.pop();
            if (older.val != tmp.val) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;

    }
    public static void main(String... args){
        ListNode listNode = ConstructListNode.constructListNode(new int[]{1, 2});
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean res = palindromeLinkedList.isPalindrome(listNode);
        System.out.println(res);
    }
}
