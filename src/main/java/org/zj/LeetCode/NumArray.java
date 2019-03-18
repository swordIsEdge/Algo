package org.zj.LeetCode;

import java.util.Scanner;

public class NumArray {
    public static void main(String... args){
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(numArray.sumRange(a, b));
        }
    }
    private int[] left;
    private int[] right;
    private int sum;
    private int len;
    public NumArray(int[] nums) {
        this.len = nums.length;
        if (len == 0) {
            return;
        }
        this.left = new int[len];
        this.right = new int[len];
        this.left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        sum = left[len - 1];

        for (int i = len-1; i >0 ; i--) {
            right[i] = sum - left[i - 1];
        }
        right[0] = sum;
    }

    public int sumRange(int i, int j) {
        if (len == 0) {
            return 0;
        }
        if (i == 0) {
            return left[j];
        }
        if (j == len - 1) {
            return right[i];
        }
        return sum - left[i - 1] - right[j + 1];

    }
}
