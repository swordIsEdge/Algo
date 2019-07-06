package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-05-12 18:10
 **/

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length-1; i >=0;i--) {
            if (!strings[i].equals(" ") && ! strings[i].isEmpty()) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        if (sb.length()!=0)sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
    public static void main(String... args){
        String s = "123       123";
        String result = new ReverseWordsinaString().reverseWords(s);
        System.out.println(result);

    }
}
