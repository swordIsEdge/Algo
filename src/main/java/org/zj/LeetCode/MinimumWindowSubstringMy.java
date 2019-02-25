package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 18:27
 **/

public class MinimumWindowSubstringMy {
    public String minWindow(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        if (sArray.length == 0 || tArray.length == 0) {
            return "";
        }

        int[] myMap = new int[256];
        int target = tArray.length;

        for (int i = 0; i < target; i++) {
            myMap[tArray[i]]++;
        }

        int count = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;

        while (right < sArray.length) {

            if (myMap[sArray[right]] > 0) {
                count++;
            }
            myMap[sArray[right]]--;

            while (count == target) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    minStart = left;
                }
                myMap[sArray[left]]++;

                if (myMap[sArray[left]] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        if (minStart == -1) {
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }
    public static void main(String... args){
        String s = "ADBCDDDDDABC";
        String t = "ABC";
        String res = new MinimumWindowSubstringMy().minWindow(s, t);
        System.out.println(res);

    }

}
