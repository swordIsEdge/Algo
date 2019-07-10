package org.zj.LeetCode.medium;

import java.util.*;

/**
 * Created by kokoro at 2019/6/25
 */
public class LongestArithmeticSequence {
    private static class Sequence {
        private final int step;
        private final LinkedList<Integer> sequence;

        public Sequence(int first, int second) {
            this.step = second - first;
            this.sequence = new LinkedList<>();
            this.sequence.add(first);
            this.sequence.add(second);
        }

        public Sequence(int step, LinkedList<Integer> sequence) {
            this.step = step;
            this.sequence = sequence;
        }

        public Sequence add(int i) {
            int last = sequence.getLast();
            if (i - last != this.step) {
                return null;
            }
            LinkedList<Integer> newSequence = new LinkedList<>(this.sequence);
            newSequence.add(i);
            return new Sequence(this.step, newSequence);
        }

        public int getHead() {
            return this.sequence.getFirst();
        }

        public int size() {
            return this.sequence.size();
        }
    }

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        if (len <= 2) {
            return len;
        }
        Set<Integer> single = new HashSet<>();
        Map<Integer, Set<Sequence>> sequences = new HashMap<>();
        for (int i : A) {
            Set<Sequence> tmp = new HashSet<>();

            for (Integer integer : single) {
                tmp.add(new Sequence(integer, i));
            }
            single.add(i);

            for (Set<Sequence> value : sequences.values()) {
                for (Sequence sequence : value) {
                    Sequence newSequence = sequence.add(i);
                    if (newSequence!=null){
                        tmp.add(newSequence);
                    }
                }
            }

            for (Sequence sequence : tmp) {
                int head = sequence.getHead();
                Set<Sequence> singleSet = sequences.getOrDefault(head, new HashSet<Sequence>());
                singleSet.add(sequence);
                sequences.put(head, singleSet);
            }


        }


        int max = 1;
        for (Set<Sequence> value : sequences.values()) {
            for (Sequence sequence : value) {
                max = Integer.max(max, sequence.size());

            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] A = {20,1,15,3,10,5,8};
        int res = new LongestArithmeticSequence().longestArithSeqLength(A);
        System.out.println(res);
    }
}
