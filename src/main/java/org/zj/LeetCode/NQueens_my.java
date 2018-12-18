package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 11:34
 **/

public class NQueens_my {
    private int[] position;
    private List<List<String>> result;
    private int n;

    private boolean check(int line) {
        for (int i = 1; i < line; i++) {
            if (position[i] == position[line] || position[i] - i == position[line] - line || position[i] + i == position[line] + line) {
                return false;
            }
        }
        return true;
    }

    private void saveResult() {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }

        for (int i = 1; i <= n; i++) {
            char[] tmp = Arrays.copyOf(chars, n);
            tmp[position[i] - 1] = 'Q';
            list.add(new String(tmp));
        }
        result.add(list);
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.result = new ArrayList<>();
        this.position = new int[n + 2];

        int k = 1;
        position[k] = 1;

        while (k>0) {
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
                saveResult();
                k--;
                position[k]++;
            }
        }
        return result;
    }
    public static void main(String... args){
        new NQueens_my().solveNQueens(4);
    }
}
