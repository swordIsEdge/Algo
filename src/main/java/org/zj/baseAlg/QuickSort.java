package org.zj.baseAlg;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 12:15
 **/

public class QuickSort {
    int partition(int[] data, int lo, int hi) {
        int i = lo, j = hi;
        int flag = data[lo];
        while (true) {
            while (data[++i] < flag) {
                if (i == hi) {
                    break;
                }
            }
            while (data[--j] > flag) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);

        }
        return j;
    }

    void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String... args){
        int[] data = {8,7,6,5};
        int index = new QuickSort().partition(data, 0, data.length - 1);
    }
}
