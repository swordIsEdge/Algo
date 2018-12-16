package org.zj.LeetCode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 16:28
 **/

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>(((o1, o2) -> o2.getValue()-o1.getValue()));
        for (int i = 0; i < height.length; i++) {
            heap.add(new Pair<>(i, height[i]));
        }
        Pair<Integer, Integer> last = heap.poll();
        int lastIndex = last.getKey();
        int sum = 0;
        int left = lastIndex, right = lastIndex;

        int tmpIndex,tmpValue;
        while (!heap.isEmpty()) {
            last = heap.poll();
            tmpIndex = last.getKey();
            if (tmpIndex >= left && tmpIndex <= right) {
                continue;
            }
            tmpValue = last.getValue();

            if (tmpIndex < left) {
                for (int i = tmpIndex; i < left; i++) {
                    sum += (tmpValue - height[i]);
                }
                left = tmpIndex;
                continue;
            } else {
                for (int i = right+1; i <= tmpIndex; i++) {
                    sum += (tmpValue - height[i]);
                }
                right = tmpIndex;
            }
        }
        return sum;
    }
    public static void main(String... args){
        int[] hs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = new TrappingRainWater().trap(hs);
        System.out.println(res);

    }
}
