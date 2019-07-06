package org.zj.LeetCode.hard;

import java.util.Stack;

/**
 * @program: Algo
 * @description: +
 * @author: kasumi
 * @create: 2019-04-01 12:58
 **/

public class BasicCalculator{
    public static void main(String... args){
        BasicCalculator calculator = new BasicCalculator();
        String s = "5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))";
        int res = calculator.calculate(s);
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

                    }
                    tmp = 0;
                    sign = 1;
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
