package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int max = 0;
        int i = 0, j = 0;
        while (j < len) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i );

            }

        }
        return max;
    }
    public static void main(String... args){
        String s = "pwwkew";
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
