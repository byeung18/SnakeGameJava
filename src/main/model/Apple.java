package model;

import java.util.Observer;
import java.util.Observable;

public abstract class Apple implements Observer {
    private int xloc;
    private int yloc;
    private String color;

    public Apple(int xloc, int yloc) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.color = null;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Apple " + arg + " added to Board!");
    }


    public void setLoc(int xloc, int yloc) {
        //modifies: xloc and yloc
        this.xloc = xloc;
        this.yloc = yloc;
    }

    public int getXloc() {
        //effects: return xloc
        return xloc;
    }

    public int getYloc() {
        //effects: return yloc
        return yloc;
    }

    //    public boolean isOnBoard() {
//        return board != null;
//    }
//
//    public void addBoard(Board board) {
//        this.board = board;
//        board.addApple(this);
//    }
//
//    public void removeBoard() {
//        this.board.eatApple(this);
//        this.board = null;
//    }
}
