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

    @Test
    public void testSaveLoad(){
        board.save("testSaveLoad.txt");
        Board newBoard = new Board(board.getSize());
        newBoard.load("testSaveLoad.txt");
        for (int i = 0; i < board.getSize(); i++)
        {
            for (int j = 0; j < board.getSize(); j++){
                assertEquals(board.display[i][j], newBoard.display[i][j]);
            }
        }
    }
}

