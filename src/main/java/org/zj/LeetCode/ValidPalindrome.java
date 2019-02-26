package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 15:07
 **/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }


        }
        String newS = sb.toString();
        int len = newS.length();
        for (int i = 0,j=len-1; i <=j ; i++,j--) {
            if (newS.charAt(i) != newS.charAt(j)) {
                return false;
            }
        }
        return true;


    }
    public static void main(String... args){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "0P";
        boolean res = validPalindrome.isPalindrome(s);
        System.out.println(res);

    }
}
