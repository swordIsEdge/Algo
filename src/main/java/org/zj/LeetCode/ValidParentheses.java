package org.zj.LeetCode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (!(stack.pop() == '(')) {
                        return false;
                    }
                    break;

                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if (!(stack.pop() == '[')) {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (!(stack.pop() == '{')) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
@Test
    public void testMatch() {
    String s = "()[]{}";
    assertTrue(isValid(s));


}

}
