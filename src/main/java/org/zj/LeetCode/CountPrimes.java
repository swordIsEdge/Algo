package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 10:50
 **/

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        result[0] = 0;
        result[n - 1] = 0;

        for (int i = 0; i*i <= n; i++) {
            if (result[i] == 0) {
                continue;
            }
            int tmp = result[i];
            for (int j = 2*tmp-1; j <n ; j+=tmp) {
                result[j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] > 0) {
                count++;
            }
        }
        return count;

    }

    public static void main(String... args){
        CountPrimes cp = new CountPrimes();
        int res = cp.countPrimes(10);
        System.out.println(res);
    }
}
