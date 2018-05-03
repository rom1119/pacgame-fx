package com.pacgame.model;

import javafx.geometry.Point2D;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PacmanTest extends TestCase {

    private Pacman pac;

    public void setUp() throws Exception {
        super.setUp();

        pac = new Pacman(new Point2D(0, 0), 25);

    }

    public void tearDown() throws Exception {
    }

    public void testTurnLeft() {

        pac.turnLeft();
        Assert.assertEquals(90, pac.getIcon().getRotate(), 0);

    }

    public void testTurnRight() {
    }

    public void testTurnUp() {
    }

    public void testTurnDown() {

    }

    public void testMoveLeft() {
    }

    public void testMoveRight() {
    }

    public void testMoveUp() {

    }

//    @Test(expected = Exception.class)
    public void testMoveDown() {


//        try {
            pac.moveDown(10);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void testGetCollider() {
    }

    public void testSetCollider() {
    }

    public void testGetIcon() {
    }

    public void testSetIcon() {
    }

    public void testGetPoint() {
    }

    public void testSetPoint() {
    }

    public void testGetWidth() {
    }

    public void testSetWidth() {
    }

    public void testGetHeight() {
    }

    public void testSetHeight() {
    }

    public void testCont() {
    }

    public void testInitPosition() {
    }
}