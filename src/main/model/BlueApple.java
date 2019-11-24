package model;

public class BlueApple extends Apple {

    private String color;

    // blue apple at location xloc, yloc
    public BlueApple(int xloc, int yloc) {
        super(xloc, yloc);
        this.color = "blue";
    }

//    public String getColor() {
//        return color;
//    }
}
