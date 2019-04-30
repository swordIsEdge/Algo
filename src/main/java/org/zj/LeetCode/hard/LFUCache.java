package org.zj.LeetCode.hard;

import java.util.HashMap;

class LFUNode{
    static LFUNode head;
    Integer value;
    int times;
    LFUNode pre,nxt;

    public LFUNode(Integer value) {
        this.value = value;
        this.times = 0;
    }
    public void hit(){
        times++;
        while (pre!=null && this.times>pre.times){
            pre.nxt = this.nxt;
            if (this.nxt != null) {
                this.nxt.pre = pre;
            }

            this.nxt = pre;
            this.pre = pre.pre;

            this.nxt.pre = this;
            if (this.pre != null) {
                this.pre.nxt = this;
            }
        }
        while (head.pre!=null){
            head = head.pre;
        }
    }
    public  void removeNode(){
        if (this==head){
            head = this.nxt;
        }
        if (nxt==null && pre==null){
            return;
        }
        if (nxt==null){
            pre.nxt = null;
            return;

        }
        if (pre==null){
            nxt.pre = null;
            return;
        }
        this.pre.nxt = this.nxt;
        this.nxt.pre = this.pre;

    }
}

public class LFUCache {
    HashMap<Integer,LFUNode> map;
    int cap;
    int size;
    public LFUCache(int capacity) {

        map =   new HashMap<>();
        this.cap = capacity;
        this.size = 0;
    }

    public int get(int key) {
        LFUNode node = map.getOrDefault(key,null);
        if (node == null) {
            return -1;
        }

        node.hit();
        return node.value;

    }

    public void put(int key, int value) {
        if (size == cap){}
        if (size==0){

        }

    }

}
