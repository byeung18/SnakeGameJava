package ui;

import ui.Apple;

public class Board {

    private int size;

    public Board(int size) {
        this.size = size;
    }

    public void setSize(int size) {
        //modifies: set new size for board
        this.size = size;
    }

    public int getSize() {
        //effects: returns size of board
        return size;
    }


}
