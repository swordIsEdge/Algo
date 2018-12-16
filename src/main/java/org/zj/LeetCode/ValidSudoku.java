package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 13:06
 **/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[]contain = new boolean[10];
        for (int i = 0; i < 10; i++) {
            contain[i] = false;
        }
        // 行
        char tmp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp = board[i][j];
                if (tmp == '.') {
                    continue;
                }
                if (contain[tmp - '0']) {
                    return false;
                }
                contain[tmp - '0'] = true;
            }
            for (int j = 0; j < 10; j++) {
                contain[j] = false;
            }
        }


        // 列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp = board[j][i];
                if (tmp == '.') {
                    continue;
                }
                if (contain[tmp - '0']) {
                    return false;
                }
                contain[tmp - '0'] = true;
            }
            for (int j = 0; j < 10; j++) {
                contain[j] = false;
            }
        }
        // 九宫格

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //遍历9个九宫格
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tmp = board[3 * i + k][3 * j + l];
                        if (tmp == '.') {
                            continue;
                        }
                        if (contain[tmp - '0']) {
                            return false;
                        }
                        contain[tmp - '0'] = true;
                    }
                }
                for (int k = 0; k < 10; k++) {
                    contain[k] = false;
                }
            }
        }
        return true;
    }
    public static void main(String... args){
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean res = new ValidSudoku().isValidSudoku(board);
        System.out.println(res);

    }

}
