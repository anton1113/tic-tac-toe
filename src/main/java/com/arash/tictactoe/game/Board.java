package com.arash.tictactoe.game;

import com.arash.tictactoe.utils.ArrayUtils;

import java.util.Arrays;

class Board {

    private Cell[][] board;

    {
        init();
    }
    
    void turn(Player player, int i, int j) {
        board[i][j] = player.getCell();
    }
    
    boolean isTurnValid(int i, int j) {
        boolean validI = i >= 0 && i <= GameSettings.BOARD_SIZE - 1;
        boolean validJ = j >= 0 && j <= GameSettings.BOARD_SIZE - 1;
        boolean validCell = board[i][j] == Cell.EMPTY;
        return validI && validJ && validCell;
    }

    boolean playerWon(Player player) {
        boolean raw = false;
        boolean col = false;
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            if (ArrayUtils.allMatch(getRaw(i), player.getCell())) {
                raw = true;
            }
            if (ArrayUtils.allMatch(getCol(i), player.getCell())) {
                col = true;
            }
        }
        boolean diagonal = ArrayUtils.allMatch(getDiagonal(false), player.getCell());
        boolean reversedDiagonal = ArrayUtils.allMatch(getDiagonal(true), player.getCell());
        return raw || col || diagonal || reversedDiagonal;
    }

    boolean isFull() {
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            for (int j = 0; j < GameSettings.BOARD_SIZE; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            printRaw(board[i]);
        }
    }

    private Cell[] getRaw(int num) {
        return Arrays.copyOf(board[num], GameSettings.BOARD_SIZE);
    }

    private Cell[] getCol(int num) {
        Cell[] col = new Cell[GameSettings.BOARD_SIZE];
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            col[i] = board[i][num];
        }
        return col;
    }

    private Cell[] getDiagonal(boolean reversed) {
        Cell[] diagonal = new Cell[GameSettings.BOARD_SIZE];
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            int j = reversed ? i : GameSettings.BOARD_SIZE - i - 1;
            diagonal[i] = board[i][j];
        }
        return diagonal;
    }

    private void printRaw(Cell[] raw) {
        for (int i = 0; i < GameSettings.BOARD_SIZE - 1; i++) {
            System.out.print(raw[i].getValue() + " ");
        }
        System.out.println(raw[GameSettings.BOARD_SIZE - 1].getValue() + "\n");
    }

    private void init() {
        board = new Cell[GameSettings.BOARD_SIZE][GameSettings.BOARD_SIZE];
        for (int i = 0; i < GameSettings.BOARD_SIZE; i++) {
            Arrays.fill(board[i], Cell.EMPTY);
        }
    }
}
