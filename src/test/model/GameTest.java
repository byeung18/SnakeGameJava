package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameTest {
    private Game game;

    @BeforeEach
    public void runBefore() {
        game = new Game(11);
    }

    @Test
    public void testInit() {
        assertEquals(11, game.size);
        assertEquals(5, game.snake.getXloc());
        assertEquals(5, game.snake.getYloc());
    }

    @Test
    public void testUpdate() {
        game.apple = new RedApple(7, 5);
        game.update();
        assertEquals(game.apple.getXloc(), 7);
        assertEquals(game.apple.getYloc(), 5);
        assertEquals(game.snake.bodyX.get(0), 6);
        assertEquals(game.snake.bodyY.get(0), 5);
        game.update();
        assertEquals(game.snake.bodyX.get(0), 7);
        assertEquals(game.snake.bodyY.get(0), 5);
    }

    @Test
    void testRotateSnake() {
        game.rotateSnake("RIGHT");
        assertEquals("RIGHT", game.snake.getDirection());
        game.rotateSnake("LEFT");
        assertEquals("LEFT", game.snake.getDirection());
        game.rotateSnake("UP");
        assertEquals("UP", game.snake.getDirection());
        game.rotateSnake("DOWN");
        assertEquals("DOWN", game.snake.getDirection());
    }

    @Test
    void testGameOverX() {
        game.snake.bodyX.set(0, -1);
        assertTrue(game.isOver());
        game.snake.bodyX.set(0, 0);
        assertFalse(game.isOver());
        game.snake.bodyX.set(0, 12);
        assertTrue(game.isOver());
    }

    @Test
    void testGameOverY() {
        game.snake.bodyY.set(0, -1);
        assertTrue(game.isOver());
        game.snake.bodyY.set(0, 0);
        assertFalse(game.isOver());
        game.snake.bodyY.set(0, 12);
        assertTrue(game.isOver());
    }

}
