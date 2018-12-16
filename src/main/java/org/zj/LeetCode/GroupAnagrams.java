package org.zj.LeetCode;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 20:32
 **/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap< String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] keys = str.toCharArray();
            Arrays.sort(keys);
            String key = new String(keys);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
