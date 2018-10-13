package org.zj.LeetCode;

import org.zj.dataStructure.ConstructListNode;
import org.zj.dataStructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while (!heap.isEmpty()) {
            temp.next = heap.poll();
            temp = temp.next;
            if (temp.next != null) {
                heap.add(temp.next);

                temp.next = null;
            }
        }
        return preHead.next;
    }

    @Test
    public void test() {
        ListNode[] paras = {
                ConstructListNode.constructListNode(new int[]{1, 4, 5}),
                ConstructListNode.constructListNode(new int[]{1, 3, 4}),
                ConstructListNode.constructListNode(new int[]{2, 6})
        };
        ListNode expect = ConstructListNode.constructListNode(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        ListNode res = mergeKLists(paras);
        Assert.assertEquals(expect, res);

    }

}
