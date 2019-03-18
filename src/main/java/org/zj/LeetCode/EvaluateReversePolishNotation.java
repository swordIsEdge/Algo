package org.zj.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String... args) {
        String[] tokens ={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = new EvaluateReversePolishNotation().evalRPN(tokens);
        System.out.println(res);

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        int res = 0;
        for (String s : tokens) {
            if (set.contains(s)) {
                String opr = s;
                int b = stack.pop();
                int a = stack.pop();
                switch (opr) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    default:
                        break;
                }
                stack.push(res);
            } else {
                res = Integer.valueOf(s);
                stack.push(res);
            }
        }
        return res;
    }
}
