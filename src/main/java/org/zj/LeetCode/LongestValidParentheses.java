package org.zj.LeetCode;


import java.util.Stack;

/**
 * Created by kokoro at 2018/11/30
 */
public class LongestValidParentheses {
    class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void extend(String s) {
            while (start > 0 && end < s.length() - 1 && s.charAt(start - 1) == '(' && s.charAt(end + 1) == ')') {
                start--;
                end++;
            }
        }

        public boolean isContinuous(Pair other) {
            return this.end + 1 == other.start;
        }

        public Pair merge(Pair other) {
            if (isContinuous(other)) {
                return new Pair(this.start, other.end);
            }
            return null;
        }

        public int length() {
            return end - start + 1;
        }

    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Stack<Pair> stack = new Stack<>();
        int startIndex = 0;
        while (startIndex<s.length() && s.charAt(startIndex) == ')') {
            startIndex++;
        }// 确保第一个指向的是'('
        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                Pair pair = new Pair(i - 1, i);
                pair.extend(s);
                while (!stack.isEmpty() && stack.peek().isContinuous(pair)) {
                    pair = stack.pop().merge(pair);
                    pair.extend(s);
                }
                stack.push(pair);
                i = pair.end;
            }
        }
        int maxLen = 0;
        for (Pair pair : stack) {
            maxLen = Integer.max(maxLen, pair.length());
        }
        return maxLen;
    }
    public static void main(String[] args){
        String input = "()(())";
        int i = new LongestValidParentheses().longestValidParentheses(input);
        System.out.println(i);
    }
}
