package org.zj.LeetCode.hard;

import org.zj.baseAlg.HeapSort;

import java.util.HashMap;

class AllOneNode{
    String key;
    int val;
    AllOneNode pre;
    AllOneNode next;
}
public class AllOne {
    HashMap<String, AllOneNode> map ;
    AllOneNode head, tail;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        AllOneNode tmp = map.getOrDefault(key, null);
        if (tmp == null) {
            tmp = new AllOneNode();
            tmp.key = key;
            tmp.val = 1;
            map.put(key, tmp);
            if (head == null) {
                head = tmp;
            }

            if (tail == null) {
                tail = tmp;
            } else {
                tail.next = tmp;
                tmp.pre = tail;
                tail = tail.next;
            }
        } else {
            tmp.val++;
            if (head == tmp) {
                return;
            }
            while (tmp.pre != null && tmp.val > tmp.pre.val) {
                AllOneNode pre = tmp.pre;
                tmp.pre = pre.pre;
                pre.pre = tmp;

                pre.next = tmp.next;
                tmp.next = pre;

            }

        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head == null) {
            return "";
        }
        return head.key;

    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (tail == null) {
            return "";
        }
        return tail.key;
    }
}
