package com.arash.tictactoe.game;

import com.arash.tictactoe.utils.ConsoleInputNumberFactory;
import com.arash.tictactoe.utils.RandomNumberFactory;

public class Player {

    private PlayerType playerType;
    private Cell cell;

    Player(PlayerType playerType, Cell cell) {
        this.playerType = playerType;
        this.cell = cell;
    }

    Cell getCell() {
        return cell;
    }

    void turn(Board board) {
        int i = getCoordinate();
        int j = getCoordinate();
        while (!board.isTurnValid(i, j)) {
            i = getCoordinate();
            j = getCoordinate();
        }
        board.turn(this, i, j);
    }

    private int getCoordinate() {
        switch (playerType) {
            case AI: return RandomNumberFactory.nextInt(GameSettings.BOARD_SIZE);
            case HUMAN: return ConsoleInputNumberFactory.nextInt();
            default: {
                throw new IllegalStateException("Unsupported player type!");
            }
        }
    }

    @Override
    public String toString() {
        return playerType + "(" + cell.getValue() + ")";
    }
}
