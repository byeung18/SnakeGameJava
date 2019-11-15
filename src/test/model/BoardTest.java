package model;

import network.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    public void testSaveLoad() {
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

    @Test
    public void testAddApple() {
        Apple a1 = new BlueApple(3, 5);
        Apple a2 = new RedApple(2, 5);
        Apple a3 = new RedApple(2, 5);
        board.addApple(a1);
        board.addApple(a2);
        assertEquals(board.apples.size(), 2);
        assertThrows(TooManyApplesException.class, () -> board.appleAdding(a3));
        board.loadApple(a1);
        assertEquals(board.display[a1.getXloc()][a1.getYloc()], 1);
        assertEquals(board.display[a2.getXloc()][a2.getYloc()], 1);
    }

    @Test
    public void testPrintBoard() {
        board.printBoard();
        board.setUpEaten();
        Snake snake = new Snake();
        board.loadSnake(snake);
        Apple apple = new RedApple(1, 5);
        board.addApple(apple);
        board.eatApple(apple);

    }
    @Test
    void testAppleAdding() throws NoAppleException, TooManyApplesException{
        Apple apple = new RedApple(1, 5);
        board.addApple(apple);
        board.appleAdding(apple);
        board.equals(board);
    }
}

