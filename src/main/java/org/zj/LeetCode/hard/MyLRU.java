package org.zj.LeetCode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-20 19:52
 **/

public class MyLRU<K, V> {
    Map<K, LRUNode<K,V>> map = new HashMap<>();
    LinkedList<LRUNode<K, V>> list = new LinkedList<>();
    int size;

    public MyLRU(int size) {
        this.size = size;
    }

    public void put(K k, V v) {
        if (!map.containsKey(k)) {
            LRUNode<K, V> node = new LRUNode<>();
            map.put(k, node);
            addAsHead(node);
        }
        if (map.size() > size) {
            deleteLast();
        }
        LRUNode<K, V> node = map.get(k);
        node.setVal(v);
        promtNode(node);
    }

    public V get(K k) {
        if (map.containsKey(k)) {
            LRUNode<K, V> node = map.get(k);
            V val = node.getVal();
            promtNode(node);
            return val;
        } else {
            return null;
        }
    }

    private void addAsHead(LRUNode<K, V> node) {
        list.addFirst(node);
    }
    private void promtNode(LRUNode<K, V> node) {
        return;

    }

    private void deleteLast() {
        LRUNode<K,V> node  = list.removeLast();
        map.remove(node.getKey());
    }


    public static void main(String... args) {


    }

}

class LRUNode<K, V> {
    K key;
    V val;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}