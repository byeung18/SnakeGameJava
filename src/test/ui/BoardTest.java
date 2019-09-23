package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void runBefore() {
        board = new Board(15);
    }

    @Test
    public void testInit() {
        assertEquals(15, board.getSize());
    }

    @Test
    public void testSetNewSize() {
        board.setSize(7);
        assertEquals(7, board.getSize());


    }
}

