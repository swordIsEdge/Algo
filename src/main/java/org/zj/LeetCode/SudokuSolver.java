package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-16 13:32
 **/

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[][] sudo = new int[9][9];
        //用位表示数独的值
        char tmp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp = board[i][j];

                if (tmp == '.') {
                    sudo[i][j] = 0;
                } else {
                    sudo[i][j] = 1 << (tmp - '0' - 1);
                }
            }
        }
//*************//
        int[] line = new int[9];
        int[] row = new int[9];
        int[][] fg = new int[3][3];

        for (int i = 0; i < 9; i++) {
            int summon = 0;
            for (int j = 0; j < 9; j++) {
                summon |= sudo[i][j];
            }
            line[i] = summon;
        }

        for (int i = 0; i < 9; i++) {
            int summon = 0;
            for (int j = 0; j < 9; j++) {
                summon |= sudo[j][i];
            }
            row[i] = summon;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //遍历九宫格
                int summon = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        summon |= sudo[i * 3 + k][j * 3 + l];
                    }
                }
                fg[i][j] = summon;
            }
        }

        boolean update = true;
        while (update) {
            update = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudo[i][j] == 0) {
                        boolean res = handleItem(i, j, line, row, fg, sudo);
                        if (res) {
                            System.out.println(i+" , "+j+" = "+int2char(sudo[i][j]));
                        }
                        update = update || res;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudo[i][j] == 0) {
                    board[i][j] = '.';
                    continue;
                }
                board[i][j] = int2char(sudo[i][j]);
            }

        }


    }

    private char int2char(int n) {
        int res = 1;
        while ((n & 1) != 1) {
            res++;
            n = n >> 1;
        }
        return (char)(res + '0');
    }

    private boolean handleItem(int i, int j, int[] line, int[] row, int[][] fg, int[][] sudo) {
        int sudoItem = line[i] | row[j] | fg[i / 3][j / 3];
        int res = isValidate(sudoItem);
        if (res == -1) {
            return false;
        }
        sudo[i][j] = res;

        line[i] |= res;
        row[j] |= res;
        fg[i / 3][j / 3] |= res;

//        for (int k = 0; k < 9; k++) {
//            //更新行
//            if (sudo[i][k] == 0) {
//                handleItem(i, k, line, row, fg, sudo);
//            }
//        }
//        for (int k = 0; k < 9; k++) {
//            //更新列
//            if (sudo[k][j] == 0) {
//                handleItem(k, j, line, row, fg, sudo);
//            }
//        }
//        for (int k = 0; k < 3; k++) {
//            for (int l = 0; l < 3; l++) {
//                if (sudo[i / 3 * 3 + k][l / 3 * 3 + l] == 0) {
//                    handleItem(i / 3 * 3 + k, l / 3 * 3 + l, line, row, fg, sudo);
//                }
//            }
//        }
        return true;
    }

    // 判断一个数是否是正确的数独的填充值
    private int isValidate(int sudoItem) {
        sudoItem = (~sudoItem);
        sudoItem = sudoItem & 0x000001ff;
        int copy = sudoItem;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if ((sudoItem & 0x00000001) == 1) {
                count++;
            }
            sudoItem = sudoItem >> 1;
            if (sudoItem == 0) {
                break;
            }

        }

        if (count == 1) {
            return copy;
        }
        return -1;

    }

    public static void main(String... args) {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
