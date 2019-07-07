package org.zj.LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 12:27
 **/

public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s2.compareTo(s1);
        });
        for (int num : nums) {
            queue.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            if (queue.peek() == 0) {
                queue.poll();
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

}
