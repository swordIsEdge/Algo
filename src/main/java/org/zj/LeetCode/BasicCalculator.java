package org.zj.LeetCode;

import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-24 12:51
 **/

public class BasicCalculator {
    public static void main(String... args){
        BasicCalculator bc = new BasicCalculator();
        String s = "1 + 1";
        int res = bc.calculate(s);
        System.out.println(res);

    }
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int tmp = 0;
        int sign = 1;
        for (char aChar : chars) {
            switch (aChar) {
                case ' ':
                    if (tmp != 0) {
                        stack.push(tmp * sign);
                        tmp = 0;
                        sign = 1;
                    }
                    break;
                case '+':
                    if (tmp != 0) {
                        stack.push(tmp * sign);
                        tmp = 0;
                        sign = 1;
                    }
                    break;
                case '-':
                    stack.push(tmp * sign);
                    tmp = 0;
                    sign = -1;
                    break;
                case '(':
                    stack.push(sign);
                    stack.push(null);
                    tmp = 0;
                    sign = 1;
                    break;
                case ')':
                    stack.push(tmp*sign);
                    tmp = 0;
                    while (stack.peek() != null) {
                        tmp += stack.pop();
                    }
                    stack.pop(); //弹出代表左括号的null
                    sign = stack.pop();
                    stack.push(tmp*sign);
                    tmp = 0;
                    sign = 1;
                    break;
                default:
                    tmp = tmp * 10 + (aChar - '0');
            }
        }
        if (tmp != 0) {
            stack.push(tmp * sign);
            tmp = 0;
        }

        while (stack.size() >0) {
            tmp += stack.pop();
        }
        stack.push(tmp);
        return stack.pop();
    }
}
