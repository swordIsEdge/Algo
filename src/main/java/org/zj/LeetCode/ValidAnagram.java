package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 12:09
 **/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] sTimes = getTimes(s);
        int[] tTimes = getTimes(t);
        for (int i = 0; i < 26; i++) {
            if (sTimes[i] != tTimes[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getTimes(String s) {
        int[] times = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            times[s.charAt(i) - 'a']++;
        }
        return times;
    }
    public static void main(String... args){
        ValidAnagram va = new ValidAnagram();
        String s = "rat";
        String t = "car";
        boolean res = va.isAnagram(s, t);
        System.out.println(res);
    }
}
