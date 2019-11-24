package model;

import java.util.ArrayList;

public class Snake {
    private int xloc;
    private int yloc;
    private int length;
    private String direction;
    public ArrayList<Integer> bodyX;
    public ArrayList<Integer> bodyY;


    public Snake() {
        xloc = 0;
        yloc = 0;
        length = 1;
        direction = "RIGHT";
        bodyX = new ArrayList<>();
        bodyY = new ArrayList<>();
    }

    public void setLoc(int xloc, int yloc) {
        //modifies: sets new xloc and yloc, reinitialize snake to size 1 body
        this.xloc = xloc;
        this.yloc = yloc;
        bodyX = new ArrayList<>();
        bodyY = new ArrayList<>();
        bodyX.add(0, xloc);
        bodyY.add(0, yloc);
    }

    public int getXloc() {
        //effect: returns xloc
        return xloc;
    }

    public int getYloc() {
        //effect: returns yloc
        return yloc;
    }

    public void longer() {
        //modifies: increment length by 1
        length++;
    }

    public int getLength() {
        //effect: return length
        return length;
    }

    public void setDirectionLeft() {
        //modifies: set direction as LEFT
        direction = "LEFT";
    }

    public void setDirectionRight() {
        //modifies: set direction as RIGHT
        direction = "RIGHT";
    }

    public void setDirectionUp() {
        //modifies: set direction as UP
        direction = "UP";
    }

    public void setDirectionDown() {
        //modifies: set direction as DOWN
        direction = "DOWN";
    }

    public void setDirection(String direction) {
        // modifies: set direction to direction given
        this.direction = direction;
    }

    public String getDirection() {
        //effect: return direction
        return direction;
    }

    // REQUIRES: active snake with directions
    // MODIFIES: snake body (bodyX, bodyY)
    // EFFECTS: moves snake by one step: adds new location of head to body
    //          and removes tail index of body
    public void move() {
        int headX = bodyX.get(0);
        int headY = bodyY.get(0);
        if (direction.equals("UP")) {
            bodyX.add(0, headX);
            bodyY.add(0, headY - 1);
        } else if (direction.equals("DOWN")) {
            bodyX.add(0, headX);
            bodyY.add(0, headY + 1);
        } else if (direction.equals("LEFT")) {
            bodyX.add(0, headX - 1);
            bodyY.add(0, headY);
        } else if (direction.equals("RIGHT")) {
            bodyX.add(0, headX + 1);
            bodyY.add(0, headY);
        }
        bodyX.remove(bodyX.size() - 1);
        bodyY.remove(bodyY.size() - 1);
    }
}
