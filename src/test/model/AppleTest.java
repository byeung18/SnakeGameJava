package model;

import model.Apple;
import model.RedApple;
import model.BlueApple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppleTest {
    private Apple apple;
    private Apple redApple;
    private Apple blueApple;

    @BeforeEach
    public void runBefore() {
        apple = new RedApple(4, 5);
        redApple = new RedApple(3, 4);
        blueApple = new BlueApple( 2, 6);
    }

    @Test
    public void testInit() {
        assertEquals(4, apple.getXloc());
        assertEquals(5, apple.getYloc());
        assertEquals(3, redApple.getXloc());
        assertEquals(4, redApple.getYloc());
        assertEquals(2, blueApple.getXloc());
        assertEquals(6, blueApple.getYloc());
    }

    @Test
    public void testSetNewLoc() {
        apple.setLoc(6, 7);
        assertEquals(6, apple.getXloc());
        assertEquals(7, apple.getYloc());
        redApple.setLoc(1, 3);
        assertEquals(1, redApple.getXloc());
        assertEquals(3, redApple.getYloc());
    }

    @Test
    public void testGetColor() {
        assertEquals("red", redApple.getColor());
        assertEquals("blue", blueApple.getColor());
    }


}
