package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 13:11
 **/

class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "( " + start + " , " + end + " )";
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));
        List<Interval> result = new ArrayList<>();
        Interval last = null;
        Interval tmp;
        for (int i = 0; i < intervals.size(); i++) {
            tmp = intervals.get(i);
            if (last == null) {
                last = tmp;
            } else if (last.end < tmp.start) {
                result.add(last);
                last = tmp;
            } else {
                last.end = Math.max(last.end, tmp.end);
            }
        }
        result.add(last);
        return result;


    }
}
