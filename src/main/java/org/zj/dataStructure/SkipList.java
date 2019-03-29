package org.zj.dataStructure;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-25 13:15
 **/

public class SkipList {

    class SkipNode{
        int val;
        SkipNode nextNode;
        SkipNode nextLevel;

        public SkipNode(int val) {
            this.val = val;
        }

        public SkipNode generateHead() {
            return new SkipNode(Integer.MIN_VALUE);
        }
        public SkipNode generateTail() {
            return new SkipNode(Integer.MAX_VALUE);
        }
    }

    public void insert(int val) {

    }

    public boolean contain(int val) {
        return false;
    }

    public boolean delete(int val) {
        return false;
    }

}
