package org.zj.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 10:31
 **/

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int m = -1;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            m = squareSum(n);
            if (m == 1) {
                return true;
            }
            if (set.contains(m)) {
                return false;
            }
            set.add(m);
            n = m;
        }
    }

    private int squareSum(int n) {
        int res = 0;
        int temp = 0;
        while (n > 0) {
            temp = n % 10;
            n = n / 10;
            res = res + temp * temp;
        }
        return res;
    }
    public static void main(String... args){
        HappyNumber hn = new HappyNumber();
        boolean result = hn.isHappy(2);
        System.out.print(result);
    }

}
