package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:07
 **/

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        int sum;
        while (i <= j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }
}
