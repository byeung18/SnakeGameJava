package ui;

public class Apple {
    private int xloc;
    private int yloc;

    public Apple(int xloc, int yloc) {
        this.xloc = xloc;
        this.yloc = yloc;
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
