package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:11
 **/

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tmpA,tmpB ;

        tmpA = headA;
        while (tmpA != null) {
            tmpA = tmpA.next;
            lenA++;
        }

        tmpB = headB;
        while (tmpB != null) {
            tmpB = tmpB.next;
            lenB++;
        }


        tmpA = headA;
        tmpB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                tmpA = tmpA.next;
            }
        }

        if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                tmpB = tmpB.next;
            }
        }

        while (tmpA != null) {
            if (tmpA == tmpB) {
                return tmpA;
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;

    }
}
