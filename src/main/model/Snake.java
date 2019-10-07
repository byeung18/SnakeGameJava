package model;

public class Snake {
    private int xloc;
    private int yloc;
    private int length;
    private String direction;


    public Snake() {
        xloc = 0;
        yloc = 0;
        length = 1;
        direction = "RIGHT";
    }

    public void setLoc(int xloc, int yloc) {
        //modifies: sets new xloc and yloc
        this.xloc = xloc;
        this.yloc = yloc;
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

    public String getDirection() {
        //effect: return direction
        return direction;
    }
}
