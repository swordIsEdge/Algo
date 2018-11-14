package org.zj.LeetCode;

import org.junit.Test;

//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like . or *.
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }
    public boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }
        if (pIndex >= p.length()) {
            return false;
        }
        if (p.charAt(pIndex) == '*') {
            return isMatch(s, sIndex, p, pIndex - 1) || isMatch(s, sIndex, p, pIndex + 1);
        }else {
            return charEqual(s,sIndex,p,pIndex) && isMatch(s, sIndex + 1, p, pIndex + 1) ||
                    canJump(p, pIndex) && isMatch(s, sIndex, p, pIndex + 2);

        }
    }

    private boolean canJump(String s, int index) {
        return index + 1 < s.length() && s.charAt(index + 1) == '*';
    }

    private boolean charEqual(String s,int sIndex,String p,int pIndex) {
        return sIndex<s.length()&&(p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex));
    }

    @Test
    public void test() {
        String s = "ab";
        String p = ".*c";
        boolean exp = false;
        boolean res = isMatch(s, p);
        assert res == exp;
    }


}
// 从讨论区偷来的一个答案
class Discussion1{
    public boolean isMatch(String s, String p) {
        //若包含*或者.，则需要特殊化处理，若不包含，则直接比较字符串。
        if (p.contains(".") || p.contains("*")) {

            //若p长度为1，那么只需比较p[0]和s[0]是否匹配
            //若p的第二个不是*，那么不需要考虑后续匹配，直接比较p[0]与s[0]
            if (p.length() == 1 || p.charAt(1) != '*')
                //s的第一个字符符合要求，且之后的也符合。
                return comp(s, p, s.length(), 0) && isMatch(s.substring(1), p.substring(1));

            //p[1]==*的情况，需要考虑当前字符匹配0次，还是多次。
            for (int i = 0; i == 0 || comp(s, p, s.length(), i - 1); i++) {
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
            }
        }
        return s.equals(p);
    }
    //比较s的第i个字符是否与p的开头匹配。
    private boolean comp(String s, String p, int sLen, int i) {
        boolean res = sLen > i && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.');
        return res;
    }
}












