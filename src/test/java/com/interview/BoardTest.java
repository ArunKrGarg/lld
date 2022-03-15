package com.interview;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGrid() {
        Board board = new Board(3);
        assertThat(board.getGrid()[0][0], is(-1));
    }
}