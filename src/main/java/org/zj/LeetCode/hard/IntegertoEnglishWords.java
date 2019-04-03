package org.zj.LeetCode.hard;

import java.util.Arrays;
import java.util.List;

public class IntegertoEnglishWords {
    String[] stringMap = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tenPlusMap = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] tensMap = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = Arrays.asList("", "Thousand", "Million", "Billion");
        int tmp;
        for (int i = 0; i < list.size(); i++) {

            tmp = num % 1000;
            num /= 1000;
            String tmp2String = getThreeDigits(tmp);
            if (tmp2String == null) {
                continue;
            } else {
                if (sb.length()>0) sb.insert(0, " ");
                sb.insert(0, list.get(i));
                if (sb.length()>0) sb.insert(0, " ");
                sb.insert(0, tmp2String);
            }
        }
        return sb.toString();
    }

    private String getThreeDigits(int threeDigit) {
        if (threeDigit < 1) {
            return null;
        }
        int firstDigit = threeDigit % 10,
                secondDigit = threeDigit / 10 % 10,
                thirdDigit = threeDigit / 100;
        StringBuilder sb = new StringBuilder();

        if (thirdDigit != 0) {
            sb.append(stringMap[thirdDigit]);
            sb.append(" ");
            sb.append("Hundred");

            if (secondDigit != 0 || firstDigit != 0) {
                sb.append(" ");
            }
        }


        if (secondDigit == 0) {
            if (firstDigit > 0) {
//                sb.append(" ");
                sb.append(stringMap[firstDigit]);
            }
        } else if (secondDigit == 1) {
//            sb.append(" ");
            sb.append(tenPlusMap[firstDigit]);
        } else {
//            sb.append(" ");
            sb.append(tensMap[secondDigit]);
            if (firstDigit > 0) {
                sb.append(" ");
                sb.append(stringMap[firstDigit]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 4, 10, 14, 40, 43, 100, 101, 120, 200, 235};
        int[] nums = {12345, 1234567, 1234567891};
        IntegertoEnglishWords thisObj = new IntegertoEnglishWords();
        for (int num : nums) {
            String s = thisObj.numberToWords(num);
            System.out.println(s);

        }
    }
}
