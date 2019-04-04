package org.zj.LeetCode.easy;

public class AddDigits {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            num = getDigitSum(num);
        }
        return num;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum+=num%10;
            num /= 10;
        }
        return sum;
    }

}
