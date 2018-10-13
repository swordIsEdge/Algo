package org.zj.LeetCode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();

        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                break;
            }
        }
        return strs[0].substring(0, i);

    }
}
