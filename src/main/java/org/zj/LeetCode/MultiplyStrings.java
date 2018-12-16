package org.zj.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 17:57
 **/

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        Set<char[]> set = new HashSet<>();
        int len1 = num1Chars.length;
        int len2 = num2Chars.length;

        if (len1 < len2) {
            //对ch1 遍历
            for (int i =0; i < len1; i++) {
                set.add(mulChar(num2Chars, num1Chars[len1 - 1 - i], i));
            }
        } else {
            for (int i = 0; i < len2; i++) {
                set.add(mulChar(num1Chars, num2Chars[len2 - 1 - i], i));

            }
        }
        char[] resChars = {'0'};
        for (char[] chars : set) {
            resChars = add(resChars, chars);
        }
        int i;
        for ( i = 0; i < resChars.length - 1; i++) {
            if (resChars[i] != '0') {
                break;
            }
        }
        resChars = Arrays.copyOfRange(resChars, i, resChars.length);
        return new String(resChars);
    }

    private char[] mulChar(char[] s, char c,int zeroCount) {

        char[] result = new char[s.length + 1+zeroCount];
        int len = s.length ;
        for (int i = len; i < result.length; i++) {
            result[i] = '0';
        }

        int a = c - '0';
        int b, i = 0, sum;

        for (int j = 0; j < len; j++) {
            b = s[s.length - 1 - j] - '0';
            sum = a * b + i;
            result[len - j] = (char) (sum % 10 + '0');
            i = sum / 10;
        }
        result[0] = (char) (i + '0');

        if (result[0] == '0') {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }


    }

    private char[] add(char[] s1, char[] s2) {
        int len1 = s1.length, len2 = s2.length;
        int len = Math.max(len1, len2) + 1;
        char[] result = new char[len];
        int a, b, i = 0, sum;
        for (int j = 0; j < len - 1; j++) {
            a = j < len1 ? s1[len1 - 1 - j] - '0' : 0;
            b = j < len2 ? s2[len2 - 1 - j] - '0' : 0;
            sum = a + b + i;
            result[len - 1 - j] = (char) ((sum % 10) + '0');
            i = sum / 10;
        }
        result[0] = (char) (i + '0');

        if (result[0] == '0') {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }

    }

    public static void main(String... args) {
        String s1 = "9133";
        String s2 = "0";
        String res = new String(new MultiplyStrings().multiply(s1, s2));

        System.out.println(res);
    }
}
