package org.zj.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-27 12:12
 **/

public class Test {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int test(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);

        }
        return ans;

    }
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()]; // dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度
        dp[0] = 1;
        int maxdp = 1;// 记录最大的值
        for (int dpIndex = 1; dpIndex < dp.length; dpIndex++) { // 遍历每个位置
            int startP = dpIndex - dp[dpIndex - 1]; //以上一个位置结尾的，不包含重复字符的最长子字符串的起始位置
            int i;
            for (i = dpIndex - 1; i >= startP; i--) {// 从前一个位置回溯，看当前字符是否包含在  以上一个位置结尾的不包含重复字符的最长子字符串中
                if (s.charAt(dpIndex) == s.charAt(i)) {//如果包含
                    break;
                }
            }
            dp[dpIndex] = dpIndex - i;//以当前位置结尾的不包含重复字符的最长子字符串长度
            if (dp[dpIndex] > maxdp) {
                maxdp = dp[dpIndex];
            }
        }
        return maxdp;
    }
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dpPre = 0; // 以上一个字符结尾的不包含重复字符的最长子字符串的长度
        int maxdp = 0;// 记录最大的值
        int[] position = new int[128]; // 记录上个字符出现的位置
        for (int i = 0; i < 128; i++)
            position[i] = -1;
        for (int dpIndex = 0; dpIndex < s.length(); dpIndex++) { // 遍历每个位置
            int preIndex = position[s.charAt(dpIndex)];
            if (preIndex < 0 || dpIndex - preIndex > dpPre) {
                dpPre++;
            } else {
                dpPre = dpIndex - preIndex;
            }
            if (dpPre > maxdp) {
                maxdp = dpPre;
            }
            position[s.charAt(dpIndex)] = dpIndex;
        }
        return maxdp;
    }


}
