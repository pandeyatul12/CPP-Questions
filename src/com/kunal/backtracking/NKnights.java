package com.kunal.backtracking;

public class NKnights {

    public static void main(String[] args) {

        int n = 4;

        boolean[][] board = new boolean[n][n];

        nknight(board, 0, 0, board.length);
    }

    public static void nknight(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            display(board);
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            nknight(board, row + 1, 0, knight);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            nknight(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }

        nknight(board, row, col + 1, knight);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(row - 2, col - 1, board)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(row - 1, col - 2, board)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(row - 2, col + 1, board)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(row - 1, col + 2, board)) {
            return !board[row - 1][col + 2];
        }

        return true;
    }

    private static boolean isValid(int row, int col, boolean[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    public static void display(boolean[][] board) {
        for (boolean[] booleans : board) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    System.out.print("K ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

}
