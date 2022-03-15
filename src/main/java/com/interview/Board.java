package com.interview;

public class Board {
    private final int SIZE;
    private final int[][] grid;
    Board(int size){
        SIZE = size;
        grid = new int[SIZE][SIZE];
        init();
    }

    private void init(){
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                grid[i][j] = -1;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return SIZE;
    }

    public void print() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
