package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BoardScreen extends Observable {

    private int size;
    public int[][] display;

    // board to keep track of snake and apple
    public BoardScreen(int size) {
        this.size = size;
        display = new int[size][size];
    }
}
