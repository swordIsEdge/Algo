package org.zj.baseAlg;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 13:35
 **/
//大根堆
public class HeapSort {
    int[] data;
    int n;
    int cap;
    public HeapSort(int cap) {
        this.cap = cap;
        data = new int[cap + 1];
        this.n = 0;
    }
    public void add(int key) {
        if (n >= cap) {
            return;
        }
        n++;
        data[n] = key;
        swim(n);

    }
    public int get() {
        if (n == 0) {
            return -1;
        }
        int res = data[1];
        if (n == 1) {
            data[n--] = 0;
            return res;
        }
        data[1] = data[n];
        data[n--] = 0;
        sink(1);
        return res;
    }
    private void sink(int k) {
        while (k << 1 <= n) {
            int j = k << 1;
            if (j + 1 <= n && data[j + 1] < data[j]) {
                j++;
            }
            if (data[k] >= data[j]) {
                break;
            }
            exchage(k, j);
            k = j;
        }
    }
    private void swim(int k) {
        while (k >>> 1 >= 1 && data[k >>> 1] < data[k]) {
            exchage(k >>> 1, k);
            k >>>= 1;
        }
    }
    private void exchage(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
