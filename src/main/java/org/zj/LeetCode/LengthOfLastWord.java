package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 13:25
 **/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char a = ' ';
        if (s.length() == 0 || s.equals(" ")) {
            return 0;
        }
        if (s.endsWith(" ")) {
            int i;
            for (i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != a) {
                    break;
                }
            }
            if (i == -1) {
                return 0;
            }
            s = s.substring(0, i + 1);

        }


        int index = s.lastIndexOf(a);

        return s.length() - 1 - index;

    }

    public static void main(String... args) {
        int a = new LengthOfLastWord().lengthOfLastWord("a ");
        System.out.println(a);
    }
}
