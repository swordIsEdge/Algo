package org.zj.baseAlg;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 13:00
 **/

public class ShellSort {
    public void sort(int[] data) {
        int N = data.length;
        int h = 1;
        while (h  < N/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && data[j] < data[j - h]; j--) {
                    swap(data, j, j - h);
                }
            }
            h /= 3;
        }
    }
    void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
