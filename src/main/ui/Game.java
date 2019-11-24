package ui;

import model.Apple;
import model.RedApple;
import model.Snake;

import java.util.Random;

public class Game {
    public int size;
    private Random randomNG;
    public Snake snake;
    public Apple apple;

    public void setBoardSize(int size) {
        this.size = size;
    }

    // EFFECTS: snake is at centre of board and apple random location on board
    public Game(int size) {
        this.size = size;
        randomNG = new Random();
        snake = new Snake();
        snake.setLoc(size / 2, size / 2);
        apple = new RedApple(randomNG.nextInt(size), randomNG.nextInt(size));
    }

    // modified code from class lab 6
    // REQUIRES: !isOver()
    // MODIFIES: this
    // EFFECTS:  move snake and decay food; if snake head is at food position, eat food and
    //           create new food at random location
    public void update() {
        snake.move();
        int headX = snake.bodyX.get(0);
        int headY = snake.bodyY.get(0);
        if (headX == apple.getXloc() && headY == apple.getYloc()) {
            snake.longer();
            snake.bodyX.add(0, headX);
            snake.bodyY.add(0, headY);
            apple = new RedApple(randomNG.nextInt(size), randomNG.nextInt(size));
        }
    }

    public void rotateSnake(String direction) {
        snake.setDirection(direction);
    }

    public boolean isOver() {
        int headX = snake.bodyX.get(0);
        int headY = snake.bodyY.get(0);
        if (headX < 0 || headX > size) {
            return true;
        } else if (headY < 0 || headY > size) {
            return true;
        } else {
            return false;
        }
    }

}
