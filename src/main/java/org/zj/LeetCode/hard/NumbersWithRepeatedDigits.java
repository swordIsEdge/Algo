package org.zj.LeetCode.hard;

import java.util.ArrayList;
import java.util.HashSet;

public class NumbersWithRepeatedDigits {
    public static void main(String[] args) {
        int n = 5432;
        int res = new NumbersWithRepeatedDigits().numDupDigitsAtMostN2(n);
    }
    public int numDupDigitsAtMostN(int N) {
        if (N <= 10 ) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int tmp = N;
        int digits = 0;
        while (tmp > 0) {
            digits++;
            list.add(0,tmp%10);
            tmp/=10;
        }
        int lowDistinct = lowDistinctCount(digits);
        int highDistinct = highDistinctCount(digits, list);
        return N - highDistinct - lowDistinct;
    }

    private int lowDistinctCount(int digits) {
        int count = 9;
        int tmp = 9;
        int product = 9;
        while (--digits > 1) {
            product *= tmp--;
            count += product;
        }
        return count;
    }

    private int highDistinctCount(int digits, ArrayList<Integer> number) {
        return -1;
    }
    public int numDupDigitsAtMostN2(int N) {
        int[] digits = new int[10];
        int digsCount = getDigits(N, digits);

        boolean[] used = new boolean[10];
        boolean numUniq = true;
        int uniq = initPermCount(digsCount);
        for (int i = digsCount - 1; i >= 0; i--) {
            for (int j = (i == digsCount - 1) ? 1 : 0; j < digits[i]; j++) {
                if (!used[j]) {
                    uniq += permCount(digsCount, digsCount - i);
                }
            }
            if (used[digits[i]]) {
                numUniq = false;
                break;
            }
            used[digits[i]] = true;
        }
        if (numUniq) {
            uniq++;
        }
        return N - uniq;
    }

    private int getDigits(int num, int[] digits) {
        int i = 0;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i++;
        }
        return i;
    }

    private int initPermCount(int digsCount) {
        int sum = 0;
        for (int i = 1; i < digsCount; i++) {
            sum += 9 * permCount(i, 1);
        }
        return sum;
    }

    private int permCount(int n, int reserved) {
        int hi = 10 - reserved, lo = hi - (n - reserved);
        int res = 1;
        while (hi > lo) {
            res *= hi--;
        }
        return res;
    }
}
