package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what size board?");
        int size = scanner.nextInt();

        while (size < 4) {
            System.out.println("too small, try again");
            System.out.println("what size board?");
            size = scanner.nextInt();
        }

        Board board = new Board(size);
        System.out.println("Board size is " + board.getSize());

        Random rand = new Random();
        Apple apple = new Apple(rand.nextInt(board.getSize()), rand.nextInt(board.getSize()));
        System.out.println("Apple location is at " + apple.getXloc() + ", " + apple.getYloc());
        board.loadApple(apple);

        Snake snake = new Snake();
        snake.setLoc(board.getSize() / 2, board.getSize() / 2);
        System.out.println("Snake location is at " + snake.getXloc() + ", " + snake.getYloc());
        board.loadSnake(snake);

        //board.printBoard();
        board.save("savedBoard.txt");


        Board newBoard = new Board(1);

        newBoard.load("savedBoard.txt");
        newBoard.printBoard();
    }


}

