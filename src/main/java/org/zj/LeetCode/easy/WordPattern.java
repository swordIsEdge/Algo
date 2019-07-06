package org.zj.LeetCode.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        new WordPattern().wordPattern(pattern, str);
    }
    public boolean wordPattern(String pattern, String str) {
        int lenP = pattern.length();
        String[] words = str.split(" ");
        int sizeW = words.length;
        if (lenP != sizeW) {
            return false;
        }
        String[] wordMap = new String[26];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < lenP; i++) {
            char c = pattern.charAt(i);
            if (Objects.isNull(wordMap[c - 'a'])) {
                if (set.contains(words[i])) {
                    return false;
                }
                wordMap[c - 'a'] = words[i];
                set.add(words[i]);
            } else {
                if (!wordMap[c - 'a'].equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
