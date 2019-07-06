package org.zj.LeetCode.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }

        for (int i = k - 1,j=0; i < nums.length; i++,j++) {
            if (deque.peek() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            res[j] = nums[deque.peekFirst()];

        }
        return res;

    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] res = swm.maxSlidingWindow(data, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
