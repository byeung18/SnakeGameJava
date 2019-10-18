package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;

public class Board implements Loadable, Saveable {

    private static final int APPLE = 1;
    private static final int SNAKE = 2;

    private int size;
    public int[][] display;
    private List<Apple> apples;

    public Board(int size) {
        this.size = size;
        display = new int[size][size];
    }

    public void setSize(int size) {
        //modifies: set new size for board
        this.size = size;
    }

    public int getSize() {
        //effects: returns size of board
        return size;
    }

    public void addApple(Apple apple) {
        try {
            apples.add(apple);
            if (apples.size() == 0) {
                throw new NoAppleException();
            } else if (apples.size() >= 10) {
                throw new TooManyApplesException();
            }
        } catch (NoAppleException e) {
            System.out.println("No apples found :(");
        } catch (TooManyApplesException e) {
            System.out.println("Too many apples!!");
        } finally {
            for (Apple a:apples) {
                loadApple(a);
            }
        }
    }

    protected void loadApple(Apple apple) {
        //modifies: display
        //effect: saves apple location on board
        display[apple.getXloc()][apple.getYloc()] = APPLE;
    }

    public void loadSnake(Snake snake) {
        //modifies: display
        //effect: saves snake location on board
        display[snake.getXloc()][snake.getYloc()] = SNAKE;
    }

    public void printBoard() {
        //effects: output board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(display[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean save(String outputFile) {
        try {
            PrintWriter printWriter = new PrintWriter(outputFile, "UTF-8");
            printWriter.println(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    printWriter.println(display[i][j]);
                }
            }
            printWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("error saving");
        }
        return false;
    }

    public boolean load(String inputFile) {

        try {
            java.io.File file = new java.io.File(inputFile);
            Scanner sc = new Scanner(file);

            size = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    display[i][j] = Integer.parseInt(sc.nextLine());
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("failed loading file");
        }
        return false;
    }
}



