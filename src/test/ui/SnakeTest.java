package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SnakeTest {
    private Snake snake;

    @BeforeEach
    public void runBefore() {
        snake = new Snake();
    }

    @Test
    public void testInit() {
        assertEquals(1, snake.getLength());
        assertEquals("RIGHT", snake.getDirection());
    }

    @Test
    public void testLength() {
        assertEquals(1, snake.getLength());
        snake.longer();
        assertEquals(2, snake.getLength());
        snake.longer();
        assertEquals(3, snake.getLength());
    }

    @Test
    public void testLocation() {
        assertEquals(0, snake.getXloc());
        assertEquals(0, snake.getYloc());
        snake.setLoc(4, 6);
        assertEquals(4, snake.getXloc());
        assertEquals(6, snake.getYloc());
    }



    @Test
    public void testSetNewDirection() {
        snake.setDirectionLeft();
        assertEquals("LEFT", snake.getDirection());
        snake.setDirectionRight();
        assertEquals("RIGHT", snake.getDirection());
        snake.setDirectionUp();
        assertEquals("UP", snake.getDirection());
        snake.setDirectionDown();
        assertEquals("DOWN", snake.getDirection());
    }
}

