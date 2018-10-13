package org.zj.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String... args) {

    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        for (String s : tokens) {
            if (set.contains(s)) {
                String opr = s;
                String b = stack.pop();
                String a = stack.pop();
            }
        }
        return -1;
    }
}
