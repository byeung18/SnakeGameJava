package model;

public class RedApple extends Apple {

    private String color;

    // red apple at location xloc, yloc
    public RedApple(int xloc, int yloc) {
        super(xloc, yloc);
        this.color = "red";
    }

//    public String getColor() {
//        return color;
//    }
}
