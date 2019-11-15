package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Board extends Observable implements Loadable, Saveable {

    private static final int APPLE = 1;
    private static final int SNAKE = 2;

    private int size;
    public int[][] display;
    public ArrayList<Apple> apples = new ArrayList<>();
    public ArrayList<Apple> eatenRedApples = new ArrayList<>();
    public ArrayList<Apple> eatenBlueApples = new ArrayList<>();
    private HashMap<String, ArrayList<Apple>> eaten = new HashMap<>();

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
            appleAdding(apple);
            this.addObserver(apple);
            setChanged();
            notifyObservers(apple);
        } catch (NoAppleException e) {
            System.out.println("No apples found :(");
        } catch (TooManyApplesException e) {
            System.out.println("Too many apples!!");
        } finally {
            for (Apple a : apples) {
                loadApple(a);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return eatenRedApples.equals(board.eatenRedApples)
                && eatenBlueApples.equals(board.eatenBlueApples)
                && eaten.equals(board.eaten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatenRedApples, eatenBlueApples, eaten);
    }

    // set up hashmap for such
    public void setUpEaten() {
        eaten.put("red", eatenRedApples);
        eaten.put("blue", eatenBlueApples);

    }

    // apple goes into hashmap
    public void eatApple(Apple apple) {
        String color = apple.getColor();
        eaten.get(color).add(apple);
        display[apple.getXloc()][apple.getYloc()] = 0;
//        apple.removeBoard();
    }

    protected void appleAdding(Apple apple) throws NoAppleException, TooManyApplesException {
        apples.add(apple);
//        apple.addBoard(this);
        if (apples.size() == 0) {
            throw new NoAppleException();
        } else if (apples.size() >= 3) {
            throw new TooManyApplesException();
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
        int value = display[snake.getXloc()][snake.getYloc()];
        if (value == APPLE) {
            eatApple(apples.get(0));
        } else {
            display[snake.getXloc()][snake.getYloc()] = SNAKE;
        }
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



