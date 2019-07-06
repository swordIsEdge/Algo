package org.zj.LeetCode.hard;

import org.zj.dataStructure.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public int runssianDollEnvelopes(Pair<Integer,Integer>[] envelops){
        Arrays.sort(envelops, Comparator.comparingInt(Pair::getKey));
        int[] lens = new int[envelops.length];
        int max  =1;
        lens[0] =1;
        for (int i = 1; i < envelops.length; i++) {
            int j = i-1;
            while (j >= 0 && envelops[j].getValue() >= envelops[i].getValue()) {
                j--;
            }
            if (j < 0) {
                lens[i] = 1;
            } else {
                lens[i] = lens[j]+1;
                max = Integer.max(max,lens[i]);
            }
        }
        return max;
    }
}
