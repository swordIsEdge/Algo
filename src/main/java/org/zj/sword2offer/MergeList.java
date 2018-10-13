package org.zj.sword2offer;

import org.zj.dataStructure.ListNode;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }


        ListNode l1Head = list1,
                l2Head = list2,
                result = new ListNode(-1),
                result_pointer = result;

        while (true) {
            if (l1Head == null) {
                result_pointer.next = l2Head;
                break;
            }
            if (l2Head == null) {
                result_pointer.next = l1Head;
                break;
            }
            if (l1Head.val >= l2Head.val) {
                result_pointer.next = l2Head;
                l2Head = l2Head.next;
            }else{
                result_pointer.next = l1Head;
                l1Head = l1Head.next;
            }
            result_pointer = result_pointer.next;

        }

        return result.next;
    }
}
