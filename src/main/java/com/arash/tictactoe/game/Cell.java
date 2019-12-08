package com.arash.tictactoe.game;

public enum Cell {

    X("X"),
    O("O"),
    EMPTY("_");

    private String value;

    Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
