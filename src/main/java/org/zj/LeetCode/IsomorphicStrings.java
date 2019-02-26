package org.zj.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 11:05
 **/

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        return core(s, t) && core(t, s);
    }

    private boolean core(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar).equals(tChar)) {
                    continue;
                }
                return false;
            } else {
                map.put(sChar, tChar);
            }

        }
        return true;
    }
}
