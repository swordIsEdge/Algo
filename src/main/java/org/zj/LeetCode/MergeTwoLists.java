package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //*********************************//
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            }
            if (l2 == null) {
                temp.next = l1;
                break;
            }

            //******************//
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return preHead.next;
    }
@Test
    public void test() {
    ListNode l1 = ConstructListNode.constructListNode(new int[]{1, 2, 4});
    ListNode l2 = ConstructListNode.constructListNode(new int[]{1, 3, 4});
    ListNode expect = ConstructListNode.constructListNode(new int[]{1, 1, 2, 3, 4, 4});
    ListNode res = mergeTwoLists(l1, l2);
    Assert.assertEquals(expect,res);
    }

















}
