package com.interview;

import com.interview.exceptions.WrongMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TicTacToe {
    private Board board;
    int currentPlayer = 0;
    boolean finished = false;
    int winner = -1;

    public void init(Board board) {
        this.board = board;
    }

    public void move() throws WrongMoveException {
        board.print();
        System.out.println("Move for player " + (currentPlayer + 1));
        int[] coords = readInt();
        Location location = new Location(coords[0], coords[1]);
        if(location.i>=board.getSize() || location.j>=board.getSize()){
            throw new WrongMoveException("Out of Board");
        }
        if(board.getGrid()[location.i][location.j] != -1) {
            throw new WrongMoveException("Already mapped");
        }
        board.getGrid()[location.i][location.j] = currentPlayer;
        finished = isFinished();
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    public Board getBoard() {
        return board;
    }

    // todo: refactor
    private static int[] readInt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
    }

    public boolean isFinished() {
        // check row
        for (int r=0;r<board.getSize();r++){
            if(board.getGrid()[r][0] == -1) continue;
            boolean finished = true;
            for(int c=1;c<board.getSize();c++){
                if(board.getGrid()[r][c] != board.getGrid()[r][0]){
                    finished = false;
                    break;
                }
            }
            if(finished){
                winner = board.getGrid()[r][0];
                return true;
            }
        }
        // check col
        for (int c=0;c<board.getSize();c++){
            if(board.getGrid()[0][c] == -1) continue;
            boolean finished = true;
            for(int r=1;r<board.getSize();r++){
                if(board.getGrid()[r][c] != board.getGrid()[0][c]){
                    finished = false;
                    break;
                }
            }
            if(finished){
                winner = board.getGrid()[0][c];
                return true;
            }
        }
        // check left diagonal
        boolean finished = true;
        if(board.getGrid()[0][0] != -1) {
            for (int i = 1; i < board.getSize(); i++) {
                if (board.getGrid()[i][i] != board.getGrid()[0][0]) {
                    finished = false;
                    break;
                }
            }
            if(finished){
                winner = board.getGrid()[0][0];
                return true;
            }
        }

        // check right diagonal
        finished = true;
        if(board.getGrid()[0][board.getSize()-1] != -1) {
            for (int i = 1; i < board.getSize(); i++) {
                if (board.getGrid()[i][board.getSize()-i-1] != board.getGrid()[0][board.getSize()-1]) {
                    finished = false;
                    break;
                }
            }
            if(finished){
                winner = board.getGrid()[0][board.getSize()-1];
                return true;
            }
        }

        return false;
    }

    public int getWinner() {
        return winner;
    }
}
