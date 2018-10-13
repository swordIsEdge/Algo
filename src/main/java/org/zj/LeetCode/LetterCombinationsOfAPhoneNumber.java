package org.zj.LeetCode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String... args) {
        List<String> res = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (String re : res) {
            System.out.println(re);
        }
    }

    HashMap<Character, String> map;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        core(digits, 0, null, res);
        return res;


    }

    private void core(String digits, int index, char[] chars, List<String> res) {
        if (index == digits.length()) {
            res.add(new String(chars));
            return;
        }
        if (index == 0) {
            chars = new char[digits.length()];
        }
        char[] alphas = map.get(digits.charAt(index)).toCharArray();
        for (Character alpha : alphas) {
            chars[index] = alpha;
            core(digits, index + 1, Arrays.copyOf(chars, digits.length()), res);
        }
    }
}
