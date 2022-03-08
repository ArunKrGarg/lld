package com.interview;

public class Board {
    int[][] grid = new int[3][3];

    public int[][] getGrid() {
        return grid;
    }

    public boolean isFinished() {
        return false;
    }

    public int getWinner() {
        return -1;
    }

}
