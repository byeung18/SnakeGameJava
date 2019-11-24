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

    // board to keep track of snake and apple
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

    // REQUIRES: apple
    // MODIFIES: apple, board
    // EFFECTS: adds new apple and loads all apples to board; also notifies new apple that it was added
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

    // REQUIRES: different board o
    // EFFECTS: checks if other board o has same hashcode to determine if equal
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

    // REQUIRES: lists of eaten apples (red, blue, both)
    // EFFECTS: returns hashcodes of the lists of apples
    @Override
    public int hashCode() {
        return Objects.hash(eatenRedApples, eatenBlueApples, eaten);
    }

    // set up hashmap for such
    // EFFECTS: set up hashup for eaten apples (red or blue)
    public void setUpEaten() {
        eaten.put("red", eatenRedApples);
        eaten.put("blue", eatenBlueApples);
    }

    // apple goes into hashmap
    // REQUIRES: hashmap of apples eaten
    // MODIFIES: eaten
    // EFFECTS: apple is stored into list of eaten apples and removed from board state
    public void eatApple(Apple apple) {
        String color = apple.getColor();
        eaten.get(color).add(apple);
        display[apple.getXloc()][apple.getYloc()] = 0;
//        apple.removeBoard();
    }

    // REQUIRES: list of apples
    // MODIFIES: list of apples
    // EFFECTS: adds apple to list of apples and throws exceptions if no apples or too many
    protected void appleAdding(Apple apple) throws NoAppleException, TooManyApplesException {
        apples.add(apple);
//        apple.addBoard(this);
        if (apples.size() == 0) {
            throw new NoAppleException();
        } else if (apples.size() >= 3) {
            throw new TooManyApplesException();
        }
    }

    // REQUIRES: active apple
    // MODIFIES: display
    // EFFECTS: saves apple location on board
    protected void loadApple(Apple apple) {
        display[apple.getXloc()][apple.getYloc()] = APPLE;
    }

    // REQUIRES: active snake, apple
    // MODIFIES: display, apple
    // EFFECTS: saves snake location on board, eats apple if same location
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

    // REQUIRES: board
    // EFFECTS: prints out board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(display[i][j] + " ");
            }
            System.out.println();
        }
    }

    // REQUIRES: board
    // MODIFIES: outputFile
    // EFFECTS: writes board state into outputFile for saving
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

    // REQUIRES: inputFile
    // MODIFIES: display
    // EFFECTS: reads board state from inputFile and loads onto display
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



