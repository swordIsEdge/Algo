package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 19:31
 **/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n -= 26;
            } else {
                sb.append(convert(n % 26));
            }
            n /= 26;
        }
        return sb.reverse().toString();

    }

    private char convert(int n) {
        return (char) (n - 1 + 'A');
    }

    public static void main(String... args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        String s = test.convertToTitle(52);
        System.out.println(s);
    }
}
