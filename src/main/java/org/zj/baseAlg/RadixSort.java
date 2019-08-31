package org.zj.baseAlg;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-13 10:58
 **/

public class RadixSort {
    public int sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);

        }
        int exp = 1, radix = 10;
        int[] aux = new int[nums.length];
        while (max / exp > 0) {
            int count[] = new int[radix];
            for (int i = 0; i < nums.length; i++) {
                count[nums[i] / exp % 10]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;
        }
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Integer.max(nums[i + 1] - nums[i], maxGap);
        }
        return maxGap;

    }
    public static void main(String... args){
        int[] nums = {3, 6, 9, 1};
        RadixSort obj = new RadixSort();
        int res = obj.sort(nums);
        System.out.println(res);
    }
}
