package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 21:36
 **/

public class WordSearch {
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        used = new boolean[board.length][board[0].length];

        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == first) {
                    boolean rs = core(board, word, i, j, 0);
                    if (rs) {
                        System.out.println(i+", "+j);
                        return true;

                    }
                }
            }
        }
        return false;

    }

    private boolean core(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (used[i][j]) {
            return false;
        }
        used[i][j] = true;
        boolean result = core(board, word, i - 1, j, index + 1)
                || core(board, word, i + 1, j, index + 1)
                || core(board, word, i, j - 1, index + 1)
                || core(board, word, i, j + 1, index + 1);
        used[i][j] = false;
        return result;

    }

    public static void main(String... args){
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String target = "ABCB";
        boolean res = new WordSearch().exist(board, target);
        System.out.println(res);

    }
}
