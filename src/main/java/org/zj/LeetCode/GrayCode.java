package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 11:46
 **/

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        if (n == 0) {
            result.add(0);
            return result;
        }
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        int[] pow = new int[n+2];
        pow[0] = 1;

        for (int i = 1; i <n+2 ; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        for (int i = 0; i < pow[n]; i++) {
            int sum = 0;
            for (int j = 0; j < n ; j++) {
                int a = i % pow[j + 2];
                if (pow[j]<=a && a<= pow[j]+pow[j+1]-1) {
                    sum += pow[j];
                }
            }
            result.add(sum);
        }
        return result;
    }
    public static void main(String... args){
        int n = 3;
        new GrayCode().grayCode(n);
    }

}
