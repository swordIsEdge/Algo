package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:27
 **/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 26 + convert(s.charAt(i));
        }
        return res;

    }

    private int convert(char c) {
        return c - 'A' + 1;
    }
}
