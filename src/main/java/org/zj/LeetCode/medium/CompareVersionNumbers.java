package org.zj.LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 12:12
 **/

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int[] nums1 = getNumsFromString(version1);
        int[] nums2 = getNumsFromString(version2);
        return compareIntArray(nums1, nums2);
    }

    private int[] getNumsFromString(String s) {
        String[] spResult = s.split("\\.");
        int[] res = new int[spResult.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(spResult[i]);
        }
        return res;
    }

    private int compareIntArray(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            nums1 = Arrays.copyOf(nums1, nums2.length);
        }
        if (nums1.length > nums2.length) {
            nums2 = Arrays.copyOf(nums2, nums1.length);
        }
        for (int i = 0; i < Integer.min(nums1.length, nums2.length); i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            return Integer.compare(nums1[i], nums2[i]);
        }
        return 0;
    }

    public static void main(String... args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        String s1 = "01";
        String s2 = "1";
        int res = obj.compareVersion(s1, s2);

        System.out.println(res);

    }
}
