package org.zj.baseAlg;

import java.util.Arrays;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 12:40
 **/

public class MergeSort {
    int[] dataDulp;

    public void sort(int[] data) {
        dataDulp = new int[data.length];
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) >>> 1;
        sort(data, lo, mid);
        sort(data, mid + 1, hi);
        merge(data, lo, mid, hi);
    }

    public void merge(int[] data, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi + 1; k++) {
            dataDulp[k] = data[k];
        }
        for (int k = lo; k < hi + 1; k++) {
            if (i > mid) {
                data[k] = dataDulp[j++];
            } else if (j > hi) {
                data[k] = dataDulp[i++];
            } else if (dataDulp[i] <= dataDulp[j]) {
                data[k] = dataDulp[i++];
            } else {
                data[k] = dataDulp[j++];
            }
        }
    }
}
