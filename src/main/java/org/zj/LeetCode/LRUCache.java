package org.zj.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class LRUCache {
    int size;
    int cap;

    private static class Node {
        int age = 0;
        int size = 0;
        ValueNode head;
        ValueNode tail;

        public Node(int age) {
            this.age = age;
        }

        public void add(ValueNode valueNode) {
            size++;
            if (head == null) {
                head = valueNode;
                tail = valueNode;
            } else {
                tail.next = valueNode;
                valueNode.pre = tail;
                tail = valueNode;
            }
        }

        public ValueNode remove(ValueNode valueNode) {
            size--;
            ValueNode pre = valueNode.pre;
            ValueNode next = valueNode.next;
            if (pre != null) pre.next = next;
            if (next != null) next.pre = pre;

            if (head == valueNode) {
                head = next;
            }
            if (tail == valueNode) {
                tail = pre;
            }

            valueNode.pre = null;
            valueNode.next = null;
            return valueNode;

        }
    }

    private static class ValueNode {
        int key;
        int value;
        Node slot;
        ValueNode pre;
        ValueNode next;

        public ValueNode(int key, int value, Node slot) {
            this.key = key;
            this.value = value;
            this.slot = slot;
        }
    }

    HashMap<Integer, ValueNode> data;
    LinkedList<Node> ageList;

    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        this.data = new HashMap<>();
        this.ageList = new LinkedList<>();
    }

    public int get(int key) {
        ValueNode node = data.get(key);
        if (Objects.isNull(node)) {
            return -1;
        } else {
            promoteValueNodeAge(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        ValueNode valueNode = data.get(key);
        if (valueNode != null) {
            update(valueNode, value);
        } else {
            if (size == cap) {
                removeLast();
            }
            add(key, value);
        }
    }

    private void update(ValueNode valueNode, int value) {

        valueNode.value = value;
        promoteValueNodeAge(valueNode);


    }

    private void add(int key, int value) {

        if (ageList.isEmpty()) {
            ageList.push(new Node(0));
        }
        Node slot = ageList.get(0);

        ValueNode valueNode = new ValueNode(key,value,slot);
        data.put(key, valueNode);
        slot.add(valueNode);
        size++;
    }

    private void removeLast() {
        Node lastUseSlot = ageList.getLast();
        while (lastUseSlot.size == 0) {
            ageList.removeLast();
            if (ageList.isEmpty()) {
                return;
            }
            lastUseSlot = ageList.getLast();
        }

        ValueNode lastUseNode = lastUseSlot.remove(lastUseSlot.head);
        data.remove(lastUseNode.key);

        while (lastUseSlot.size == 0) {
            ageList.removeLast();
            if (ageList.isEmpty()) {
                return;
            }
            lastUseSlot = ageList.getLast();
        }
        size--;
    }

    private void promoteValueNodeAge(ValueNode valueNode) {
        //提升节点的使用时间
        Node head = valueNode.slot;
        int index = ageList.indexOf(head);
        Node nextHead;
        if (index == 0) {
            nextHead = new Node(head.age + 1);
            ageList.push(nextHead);
        } else {
            nextHead = ageList.getFirst();
        }
        valueNode.slot = nextHead;
        head.remove(valueNode);
        nextHead.add(valueNode);
    }
    public static void main(String... args){
        LRUCache cache = new LRUCache(10);

        String[] ops = {"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] data ={{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};

        doOpes(cache,ops,data);

    }

    public static void doOpes(LRUCache cache, String[] ops, int[][] data) {
        int len =  ops.length;
        for (int i = 0; i < len; i++) {
            if (ops[i].equals("get")) {
                int key = data[i][0];
                int v = cache.get(key);
                System.out.println(ops[i] +"   "+ key+" = "+v);

            } else {
                int key = data[i][0];
                int v = data[i][1];
                cache.put(key, v);
                System.out.println(ops[i] +"   "+ key+", "+v);

            }
        }
    }
}
