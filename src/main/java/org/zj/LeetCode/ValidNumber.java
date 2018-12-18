package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 17:38
 **/

public class ValidNumber {
    public boolean isNumber(String s) {
        // 先去前后的空格
        //再分析字符值是否合法
        // 再判断有没有e，
        // 若有分析e前面的数，分析e后面的数是否合法
        // 若没有，则分析整个数
        if (s == null || s.length() == 0) {
            return false;
        }

        //去空格
        int start = 0;
        int end = s.length();
        if (s.startsWith(" ")) {
            int i;
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    break;
                }
            }
            start = i;
        }

        if (s.endsWith(" ")) {
            int i;
            for (i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    break;
                }
            }
            end = i + 1;
        }

        if (start >= end) {
            return false;
        }

        s = s.substring(start, end);
        if (s.length() == 0) {
            return false;
        }

        // 检测字符是否合法，以及e的个数
        int eCount = 0;
        int eIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || c == '-' || c == '+' || c == '.') {
                continue;
            }
            if (c == 'e') {
                eIndex = i;
                eCount++;
                if (eCount > 1) {
                    return false;
                }
                continue;
            }
            return false;
        }

        //分析e前后的内容或者整个数
        if (eCount == 1) {
            String left = s.substring(0, eIndex);
            if (left.startsWith("+") || left.startsWith("-")) {
                left = left.substring(1);
            }
            String right = s.substring(eIndex + 1);
            if (right.startsWith("+") || right.startsWith("-")) {
                right = right.substring(1);
            }
            return check(left, true) && check(right, false);

        } else {
            if (s.startsWith("+") || s.startsWith("-")) {
                s = s.substring(1);
            }
            return check(s, true);
        }


    }

    private boolean check(String s, boolean canHaveDigit) {
        if (s.length() == 0) {
            return false;
        }
        int digitCount = 0;
        int digitindex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                continue;

            }
            if (c == '.') {
                if (!canHaveDigit) {
                    return false;
                }
                digitCount++;
                digitindex = i;
                if (digitCount > 1) {
                    return false;
                }
                continue;

            }
            return false;
        }
        if (digitCount == 1) {
            if (s.equals(".")) {
                return false;
            }
            String left = s.substring(0, digitindex);
            String right = s.substring(digitindex + 1);

            if (left.length() == 0) {
                return checkRightDigit(right);
            }
            if (left.equals("0")) {
                return checkRightDigit(right);
            }
            return checkRightDigit(right);


        } else {
            //没有小数点，分析整个数
//            if (s.equals("0")) {
//                return true;
//            }
//            if (s.startsWith("0")) {
//                return false;
//            }
            return true;
        }

    }

    private boolean checkRightDigit(String s) {
//        if (!s.startsWith("0")) {
//            return true;
//        }
//        int i;
//        for (i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != '0') {
//                break;
//            }
//        }
//
//        if (i >= s.length()) {
//            return false;
//        }
//        return true;
        return true;
    }

    public static void main(String... args) {
        String s = "01.";
        boolean res = new ValidNumber().isNumber(s);
        System.out.println(res);

    }


}
