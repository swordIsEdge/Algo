package org.zj.LeetCode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 18:56
 **/

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        Stack<Character> stack = new Stack<>();
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);

        if (lenA > lenB) {
            char[] chars = new char[lenA - lenB];
            for (int i = 0; i < lenA - lenB; i++) {
                chars[i] = '0';
            }
            b = new String(chars) + b;
        }

        if (lenB > lenA) {
            char[] chars = new char[lenB-lenA];
            for (int i = 0; i < lenB-lenA; i++) {
                chars[i] = '0';
            }
            a = new String(chars) + a;
        }
        int charA = 0, charB = 0, carry = 0;
        int sum;
        for (int i = len - 1; i >= 0; i--) {
            charA = a.charAt(i) == '0' ? 0 : 1;
            charB = b.charAt(i) == '0' ? 0 : 1;
            sum = charA + charB + carry;
            stack.push((char) (sum % 2+'0'));
            carry = sum / 2;
        }
        if (carry == 1) {
            stack.push('1');
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String... args){
        String a = "1010";
        String b = "1011";
        String res = new AddBinary().addBinary(a, b);
        System.out.println(res);
    }
}
