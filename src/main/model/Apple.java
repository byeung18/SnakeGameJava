package model;

import java.util.Observer;
import java.util.Observable;

public abstract class Apple implements Observer {
    private int xloc;
    private int yloc;
    private String color;

    // abstract apple class with null color
    public Apple(int xloc, int yloc) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.color = null;
    }

    //effects: returns colour of apple
    public String getColor() {
        return color;
    }


    // Observable/Observer relationship with board so sout message when apple added to board
    // EFFECTS: outputs message when apple added to board
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
}
