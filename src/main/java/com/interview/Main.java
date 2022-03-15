package com.interview;


import com.interview.exceptions.WrongMoveException;

public class Main {

    public static void main(String[] args) {
	    TicTacToe ticTacToe = new TicTacToe();
        init(ticTacToe, 3);

        while(!ticTacToe.finished) {
            try {
                ticTacToe.move();
            } catch (WrongMoveException e) {
                System.out.println("Please try again.");
                continue;
            }
        }

        ticTacToe.getBoard().print();
        System.out.println("Game Finished!!\nWinner is " + (ticTacToe.getWinner() + 1));
    }

    private static void init(TicTacToe ticTacToe, int size) {
        Board board = new Board(size);
        ticTacToe.init(board);
    }
}
