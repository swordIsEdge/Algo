package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;
import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 10:04
 **/

public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }

        int[] data = new int[len];
        tmp = head;
        for (int i = 0; i < len; i++) {
            data[i] = tmp.val;
            tmp = tmp.next;
        }
        return core(data, 0, len - 1);
    }

    private TreeNode core(int[] data, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(data[start]);
        }
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(data[mid]);
        root.left = core(data, start, mid-1);
        root.right = core(data, mid + 1, end);
        return root;
    }
}
