package org.zj.LeetCode;

public class ContainerWithMostWater {
    public static void main(String... args){
        int res = new ContainerWithMostWater().maxArea(new int[]{1,3,2,5,25,24,5});
        System.out.print(res);
    }
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        if (height.length == 2) {
            return Integer.min(height[0], height[1]);
        }
        int maxA = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[j]>height[i]) {
                i++;
            } else {
                j--;
            }
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxA) {
                maxA = area;
            }
        }
        return maxA;
    }
}
