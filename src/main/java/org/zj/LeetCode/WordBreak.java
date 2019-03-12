package org.zj.LeetCode;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-01 17:43
 **/

public class WordBreak {
    /**从评论区抄来的bfs算法
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int n = queue.remove();
                if (n == s.length()) {
                    return true;
                }
                if (!visited.contains(n)) {
                    for (int i = n + 1; i <= s.length(); i++) {
                        if (dict.contains(s.substring(n, i))) {
                            queue.add(i);
                            visited.add(n);
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * 从讨论区抄来的，使用dp算法
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j <i ; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];


    }
    public boolean wordBreak0(String s, List<String> wordDict) {
        HashMap<Character, ArrayList<String>> helperMap = new HashMap<>();
        wordDict.forEach(
                word -> {
                    ArrayList<String> list = helperMap.getOrDefault(word.charAt(0), new ArrayList<String>());
                    list.add(word);
                    helperMap.put(word.charAt(0), list);
                }
        );

        return core(s, 0, helperMap);
    }

    private boolean core(String s, int index, HashMap<Character, ArrayList<String>> helperMap) {
        if (index == s.length()) {
            return true;
        }
        if (index > s.length()) {
            return false;
        }
        char c = s.charAt(index);
        if (!helperMap.containsKey(c)) {
            return false;
        }
        ArrayList<String> alters = helperMap.get(c);

        for (String alter : alters) {
            if (index + alter.length() > s.length()) {
                continue;
            }
            int i;
            for ( i = 0; i < alter.length(); i++) {
                if (s.charAt(index + i) != alter.charAt(i)) {
                    break;
                }
            }
            if (i == alter.length()) {
                boolean res = core(s, index + alter.length(), helperMap);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String... args) {
        String s = "bccdbacdbdacddabbaaaadababadad";
        List<String> list = Arrays.asList("cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb");
        boolean res = new WordBreak().wordBreak(s, list);
        System.out.print(res);

    }
}
