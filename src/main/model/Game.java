package model;

import model.Apple;
import model.RedApple;
import model.Snake;
import java.util.*;

import java.util.Random;

public class Game {
    public int size;
    private HashSet obstacles;
    private Random randomNG;
    public Snake snake;
    public Apple apple;

    // snake is at centre of board and apple random location on board
    public Game(int size) {
        this.size = size;
        //this.obstacles
        randomNG = new Random();
        snake = new Snake();
        snake.setLoc(size / 2, size / 2);
        apple = new RedApple(randomNG.nextInt(size), randomNG.nextInt(size));
    }

    // modified code from class lab 6
    // REQUIRES: !isOver()
    // MODIFIES: snake, apple
    // EFFECTS:  move snake; if snake eats apple, make new apple at random location
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

    // REQUIRES: active snake on board, !isOver()
    // MODIFIES: snake
    // EFFECTS: rotates snake in direction given
    public void rotateSnake(String direction) {
        snake.setDirection(direction);
    }

    public boolean isIntersecting() {
        int headX = snake.bodyX.get(0);
        int headY = snake.bodyY.get(0);
        for (int i = 2; i < snake.getLength(); i++) {
            if (snake.bodyX.get(i) == headX && snake.bodyY.get(i) == headY) {
                return true;
            }
        }
        return false;
    }

    // REQUIRES: active snake on board
    // MODIFIES: snake
    // EFFECTS: checks if game is over (ie. if snake head is outside of board)
    public boolean isOver() {
        int headX = snake.bodyX.get(0);
        int headY = snake.bodyY.get(0);
        //check if out of map bounds
        if (headX < 0 || headX > size) {
            return true;
        } else if (headY < 0 || headY > size) {
            return true;
        } else if (isIntersecting()) {
            return true;
        } else {
            return false;
        }
    }

}
