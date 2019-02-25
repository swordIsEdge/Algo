package org.zj.LeetCode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 21:28
 **/

public class LargestRectangleInHistogramMy {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            if (stack.isEmpty() || (i!=heights.length && heights[i] >= heights[stack.peek()])) {
                stack.push(i);
            } else {
                int h = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int width = i - start - 1;
                int area = h * width;
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;




    }
    public static void main(String... args){
        int[] nums = {1,5,4,3,8,7,6};
        int res = new LargestRectangleInHistogramMy().largestRectangleArea(nums);
        System.out.println(res);
    }
}
