package org.zj.dataStructure;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof ListNode)) {
//            return false;
//
//        }
//        ListNode other = (ListNode) obj;
//        if (this.val != other.val) {
//            return false;
//        }
//        if (this.next == null || other.next == null) {
//            return true;
//        }
//        return this.next.equals(other.next);
//    }

//    @Override
//    public String toString() {
//
//        return val + "-> " + (next == null ? "NULL" : next.toString());
//    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static ListNode getInstanceFromArray(int[] array) {
        return ConstructListNode.constructListNode(array);
    }
}

