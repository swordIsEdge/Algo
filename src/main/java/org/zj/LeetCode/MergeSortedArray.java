package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 13:45
 **/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        //从后往前
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        if (i < 0 && j >= 0) {
            for (; j >= 0; j--) {
                nums1[j] = nums2[j];
            }
        }
        return;
    }
    public static void main(String... args){
        int[] nums1 = {1, 2, 3, 0, 0, 0,};
        int[] nums2 = {2, 5, 6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}














