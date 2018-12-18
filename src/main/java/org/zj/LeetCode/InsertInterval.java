package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 13:40
 **/

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 二分搜索插入位置
        //在插入位置前一个开始合并
        //合并到某一interval的start大于插入值的end

        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int insertPosition = 0;

        if (newInterval.start <= intervals.get(0).start) {
            //插入到开头
            insertPosition = 0;
        } else if (newInterval.start > intervals.get(intervals.size() - 1).start) {
            //插入到结尾
            insertPosition = intervals.size();
        } else {
            //二分搜索
            int lo = 0, hi = intervals.size() - 1, mid = lo + (hi - lo) / 2;
            int target = newInterval.start;
            while (lo <= hi) {
                int tmpStart = intervals.get(mid).start;
                if (tmpStart < target) {
                    lo = mid + 1;
                } else {
                    //此时target<=tmpStart
                    if (intervals.get(mid - 1).start < target) {
                        insertPosition = mid;
                        break;
                    } else {
                        hi = mid - 1;
                    }
                }
                mid = lo + (hi - lo) / 2;
            }
        }


        intervals.add(insertPosition, newInterval);
        int startMergePostion = Math.max(0, insertPosition - 1);
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < startMergePostion; i++) {
            result.add(intervals.get(i));
        }

        Interval last = null;
        Interval tmp;
        for (int i = startMergePostion; i < intervals.size(); i++) {
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
    public static void main(String... args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval target = new Interval(4, 8);
        List<Interval> result = new InsertInterval().insert(intervals, target);
        for (Interval interval : result) {
            System.out.println(interval);
        }
    }
}
