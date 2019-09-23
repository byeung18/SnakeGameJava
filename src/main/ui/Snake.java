package ui;

public class Snake {
    private int length;
    private String direction;


    public Snake()
    {
        length = 1;
        direction = "RIGHT";
    }

    public void longer()
    {
        //modifies: increment length by 1
        length++;
    }

    public int getLength()
    {
        //effect: return length
        return length;
    }

    public void setDirectionLeft()
    {
        //modifies: set direction as LEFT
        direction = "LEFT";
    }

    public void setDirectionRight()
    {
        //modifies: set direction as RIGHT
        direction = "RIGHT";
    }

    public void setDirectionUp()
    {
        //modifies: set direction as UP
        direction = "UP";
    }

    public void setDirectionDown()
    {
        //modifies: set direction as DOWN
        direction = "DOWN";
    }

    public String getDirection()
    {
        //effect: return direction
        return direction;
    }
}
