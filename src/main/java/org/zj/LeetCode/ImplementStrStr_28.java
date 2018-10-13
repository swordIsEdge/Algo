package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ImplementStrStr_28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int len = needle.length();
        HashMap<Character, Integer> moveTable = new HashMap<>();
        constTable(moveTable, needle);
        int i = len - 1, j = 0;
        while (i < haystack.length()) {
            while (haystack.charAt(i - j) == needle.charAt(len - 1 - j)) {
                j++;
                if (j == len) {
                    return i - j + 1;
                }
            }

            int moveLen = moveTable.getOrDefault(haystack.charAt(i), len);
            j = 0;
            i += moveLen;


        }
        return -1;


    }


    private void constTable(HashMap<Character, Integer> moveTable, String needle) {
        int len = needle.length();
        for (int i = 0; i < len - 1; i++) {
            moveTable.put(needle.charAt(i), len - 1 - i);
        }
    }

    @Test
    public void test() {
        String hayStack = "aaaaa";
        String needle = "bba";
        int expec = -1;
        int res = strStr(hayStack, needle);
        Assert.assertEquals(expec, res);
    }
}
