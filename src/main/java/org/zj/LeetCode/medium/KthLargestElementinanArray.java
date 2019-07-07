package org.zj.LeetCode.medium;

import java.util.PriorityQueue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 10:10
 **/

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        while (queue.size()>k){
            queue.poll();
        }
        return queue.peek();
    }
}
