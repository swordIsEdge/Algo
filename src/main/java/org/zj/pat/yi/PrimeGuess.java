package org.zj.pat.yi;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeGuess {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 4) {
            System.out.println(0);
            return;
        }

       int[] primes = getPrimes(n);
        int len = primes.length;
        if (len <= 2) {
            System.out.println(0);
            return;
        }
        if (len == 3) {
            System.out.println(1);
            return;
        }
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (primes[i] == primes[i + 1] - 2 ) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int[] getPrimes(int n) {
        int[] res = new int[10000];
        int count = 0;

        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                    res[count++] = i;
            }
            for (int j = 0; j < i && res[j] * i <= n; j++) {
                primes[res[j] * i] = true;
                if (i % res[j] == 0) {
                    break;
                }
            }
        }
        int[] subRes = Arrays.copyOf(res, count);
        return subRes;
    }
}
