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

