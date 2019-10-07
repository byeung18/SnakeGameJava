package model;

import model.Apple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppleTest {
    private Apple apple;

    @BeforeEach
    public void runBefore() {
        apple = new Apple(4, 5);
    }

    @Test
    public void testInit() {
        assertEquals(4, apple.getXloc());
        assertEquals(5, apple.getYloc());
    }

    @Test
    public void testSetNewLoc() {
        apple.setLoc(6, 7);
        assertEquals(6, apple.getXloc());
        assertEquals(7, apple.getYloc());
    }
}
