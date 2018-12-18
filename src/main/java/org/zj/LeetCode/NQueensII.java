package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 12:33
 **/

public class NQueensII {


    private int[] position;
    private int n;
    private int count;

    private boolean check(int line) {
        for (int i = 1; i < line; i++) {
            if (position[i] == position[line] || position[i] - i == position[line] - line || position[i] + i == position[line] + line) {
                return false;
            }
        }
        return true;
    }


    public int totalNQueens(int n) {

        this.n = n;
        this.count = 0;
        this.position = new int[n + 2];

        int k = 1;
        position[k] = 1;

        while (k > 0) {
            if (k <= n) {
                if (position[k] > n) {
                    k--;
                    position[k]++;
                } else if (check(k)) {
                    k++;
                    position[k] = 1;
                } else {
                    position[k]++;
                }

            } else {
                //k>n
                count++;
                k--;
                position[k]++;
            }
        }
        return count;
    }
}
