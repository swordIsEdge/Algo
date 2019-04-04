package org.zj.LeetCode.medium;

public class SurroundedRegions {
    private static final char X = 'X';
    private static final char O = 'O';

    public void solve(char[][] board) {
        int row = 0, col = 0;
        if (board == null || (row = board.length) <=1 || (col = board[0].length) <= 0) {
            return;
        }
        int[] upBound = new int[col];
        int[] btmBound = new int[col];
        int[] leftBound = new int[row];
        int[] rightBound = new int[row];


        for (int i = 0; i < row; i++) {
            leftBound[i] = -1;
            rightBound[i] = -1;
            for (int j = 0; j < col; j++) {
                if (board[i][j] == X) {
                    leftBound[i] = leftBound[i]==-1?j:leftBound[i];
                    rightBound[i] = j;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            upBound[j] = -1;
            btmBound[j] = -1;
            for (int i = 0; i < row; i++) {
                if (board[i][j] == X) {
                    upBound[j] = upBound[j] == -1 ? i : upBound[j];
                    btmBound[j] = i;
                }
            }
        }

        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if (board[i][j] == O && leftBound[i] < j && j < rightBound[i] && upBound[j] < i && i < btmBound[j]) {
                    board[i][j] = X;
                }
            }
        }
    }
}
