package org.zj.pat.yi;

/**
 *计算质数的优化方法
 */
public class CalPrime {
    public static void main(String... args) {
        new CalPrime().init();
    }

    int N = 100;
    int[] prime = new int[2000];
    int[] a = new int[N];

    void init() {
        int i, j, len = 0;
        for (i = 0; i < N; i++) {
            prime[i] = 0;
        }
        for (i = 2; i <= N; i++) {
            if (prime[i] == 0) {
                a[len++] = i;
                System.out.println(i);
            }
            for (j = 0; j < len && a[j] * i <= N; j++) {
                prime[a[j] * i] = 1;
                if (i % a[j] == 0) break;
            }
        }


    }
}