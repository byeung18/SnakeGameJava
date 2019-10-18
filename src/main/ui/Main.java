package ui;

import model.*;
import model.Apple;
import model.Board;
import model.Snake;

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

        setupApple(scanner, board);
        setupSnake(board);

//        board.save("savedBoard.txt");
//
//        Board newBoard = new Board(1);
//        newBoard.load("savedBoard.txt");
//        newBoard.printBoard();
    }

    static void setupApple(Scanner scanner, Board board) {
        Random rand = new Random();
        Apple apple;
        System.out.println("What color apple? red or blue: ");
        String color = scanner.next();
        if (color.equals("blue")) {
            apple = new BlueApple(rand.nextInt(board.getSize()), rand.nextInt(board.getSize()));
        } else {
            apple = new RedApple(rand.nextInt(board.getSize()), rand.nextInt(board.getSize()));
        }
        System.out.println("Apple location is at " + apple.getXloc() + ", " + apple.getYloc());
        board.addApple(apple);
    }

    static void setupSnake(Board board) {
        Snake snake = new Snake();
        snake.setLoc(board.getSize() / 2, board.getSize() / 2);
        System.out.println("Snake location is at " + snake.getXloc() + ", " + snake.getYloc());
        board.printBoard();
    }

}

