package sword2offer;

import dataStructure.ListNode;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class FindKthToTail {
    /*可能的输入：
        1.空链表，链表null
        2.长度不足k*/
    //忽略了K为0或负数的情况
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null||k<1) {
            return null;
        }
        ListNode head_backup = head;
        ListNode point = head;

        //先找到第k个节点
        try {
            for (int i = 0; i < k - 1; i++) {
                point = point.next;
            }
        } catch (NullPointerException e) {
            return null;
        }
        if (point == null) {
            return null;
        }

        ListNode result = head;
        while (point.next != null) {
            point = point.next;
            result = result.next;
        }
        return result;
    }
}
