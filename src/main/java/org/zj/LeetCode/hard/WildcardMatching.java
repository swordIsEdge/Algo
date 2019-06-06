package org.zj.LeetCode.hard;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "abcdeacdeagcde";
        String p = "a*cde";
        boolean res = new WildcardMatching().comparison(s, p);
        System.out.println(res);
    }
    public boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            if (p < pattern.length()) {
                System.out.println(pattern.charAt(p)+"   "+str.charAt(s));
            }else {
                System.out.println("X"+"   "+str.charAt(s));
            }



            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return core(s, 0, p, 0);




    }

    private boolean core(String s, int sIndex, String p, int pIndex) {


        while (!acheiveBound(s,sIndex,p,pIndex)) {
            char c = p.charAt(pIndex);
            switch (c) {
                case '?':
                    pIndex++;
                    sIndex++;
                    break;
                case '*':
                    for (int i = sIndex; i <= s.length(); i++) {
                        if (core(s, i, p, pIndex + 1)) {
                            return true;
                        }

                    }
                    return false;
//                    break;
                default:
                    if (s.charAt(sIndex) == c) {
                        sIndex++;
                        pIndex++;
                    } else {
                        return false;
                    }
                    break;

            }
        }
        return  handleBound(s, sIndex, p, pIndex);
    }
    private boolean acheiveBound(String s,int sIndex,String p,int pIndex){
        return s.length() == sIndex || p.length() == pIndex;
    }

    private boolean handleBound(String s, int sIndex, String p, int pIndex) {
        if (s.length() == sIndex && p.length() == pIndex) {
            return true;
        }

        if (p.length() == pIndex) {
            return false;
        }

        if (s.length() == sIndex) {
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
