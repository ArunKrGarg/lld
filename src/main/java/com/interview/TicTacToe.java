package com.interview;

import java.util.Scanner;

public class TicTacToe {
    Board board;
    int currentPlayer = 0;

    public void init(Board board) {
        this.board = board;
    }

    public void step() {
        printBoard();
        System.out.println("Move for player " + (currentPlayer + 1));
        Location location = new Location(readInt(), readInt());
        board.getGrid()[location.i][location.j] = currentPlayer;
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    public Board getBoard() {
        return board;
    }

    private static int readInt() {
        Scanner myInput = new Scanner( System.in );
        return myInput.nextInt();
    }

    private void printBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
