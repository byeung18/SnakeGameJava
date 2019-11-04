package model;

public abstract class Apple {
    private int xloc;
    private int yloc;
    private Board board;
    private String color;

    public Apple(int xloc, int yloc) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.board = null;
        this.color = null;
    }

    public String getColor() {
        return color;
    }

    public boolean isOnBoard() {
        return board != null;
    }

    public void addBoard(Board board) {
        this.board = board;
        board.addApple(this);
    }

    public void removeBoard() {
        this.board.eatApple(this);
        this.board = null;
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
