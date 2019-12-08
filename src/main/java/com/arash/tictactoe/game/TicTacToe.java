package com.arash.tictactoe.game;

public class TicTacToe {

    public static void play() {
        boolean exit = false;
        Board board = new Board();
        Player player1 = new Player(PlayerType.HUMAN, Cell.X);
        Player player2 = new Player(PlayerType.AI, Cell.O);
        Player currentPlayer = player1;
        while (!exit) {
            doPlayerTurn(currentPlayer, board);
            exit = isGameFinished(currentPlayer, board);
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

    private static void doPlayerTurn(Player player, Board board) {
        System.out.println("Player " + player + " turn");
        player.turn(board);
        board.print();
    }

    private static boolean isGameFinished(Player player, Board board) {
        if (board.isFull()) {
            System.out.println("The board is full, Game over!");
            return true;
        } else if (board.playerWon(player)) {
            System.out.println("Player " + player + " won the game!");
            return true;
        } else {
            return false;
        }
    }
}
