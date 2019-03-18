package org.zj.byteDance;

import java.util.Scanner;

public class Byte3 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.valueOf(sc.nextLine());
        int n;
        int[] data;
        for (int i = 0; i < count; i++) {
            n = Integer.valueOf(sc.nextLine());
            data = new int[n];
            String[] s = sc.nextLine().split(" ");
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            int maxIndex = -1, minIndex = -1;
            for (int j = 0; j < n; j++) {
                data[j] = Integer.valueOf(s[j]);
                if (data[j] > max) {
                    maxIndex = j;
                    max = data[j];
                }
                if (data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }
            core(data, max, min, maxIndex, minIndex);
        }
    }

    private static void core(int[] data, int max, int min, int maxIndex, int minIndex) {
        int len = data.length;
        int[] left2Right = new int[len];
        int[] right2Left = new int[len];
        left2Right[minIndex] = 1;

        for (int i = minIndex+1; i < len; i++) {
            if (data[i] > data[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            } else {
                left2Right[i] = 1;
            }
        }
        if (data[0] > data[len - 1]) {
            left2Right[0] = left2Right[len - 1] + 1;
        } else {
            left2Right[0] = 1;
        }
        for (int i = 1; i < minIndex; i++) {
            if (data[i] > data[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            } else {
                left2Right[i] = 1;
            }
        }


        right2Left[minIndex] = 1;
        for (int i = minIndex - 1; i >= 0; i--) {
            if (data[i] > data[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            } else {
                right2Left[i] = 1;
            }
        }

        if ( data[len - 1]>data[0]) {
            right2Left[len-1] = right2Left[0] + 1;
        } else {
            right2Left[0] = 1;
        }
        for (int i = len-2; i > minIndex; i--) {
            if (data[i] > data[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            } else {
                right2Left[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        System.out.println(sum);

    }
}
