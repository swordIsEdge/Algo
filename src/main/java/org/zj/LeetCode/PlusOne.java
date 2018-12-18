package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 18:47
 **/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = carry;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        return res;
    }
    public static void main(String... args){
        int[] digits = {9};
        int[] res = new PlusOne().plusOne(digits);
        for (int re : res) {
            System.out.print(re);
        }
    }
}
