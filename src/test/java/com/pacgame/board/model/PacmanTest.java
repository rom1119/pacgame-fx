package com.pacgame.board.model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;
import junit.framework.TestCase;
import org.junit.Assert;

public class PacmanTest extends TestCase {

    private Pacman pac;

    public void setUp() throws Exception {
        super.setUp();

        pac = new Pacman(new Point2D(0, 0), 25);

    }

    public void tearDown() throws Exception {
    }

//    public void testTurnLeft() {
//
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//        pac.turnLeft();
//        Assert.assertEquals(180, pac.getIcon().getRotate(), 0);
//        pac.turnLeft();
//        Assert.assertEquals(180, pac.getIcon().getRotate(), 0);
//
//    }
//
//    public void testTurnRight() {
//
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//        pac.turnRight();
//        Assert.assertEquals(0, pac.getIcon().getRotate(), 0);
//        pac.turnRight();
//        Assert.assertEquals(0, pac.getIcon().getRotate(), 0);
//    }
//
//    public void testTurnUp() {
//
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//        pac.turnUp();
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//        pac.turnUp();
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//    }
//
//    public void testTurnDown() {
//
//        Assert.assertEquals(270, pac.getIcon().getRotate(), 0);
//        pac.turnDown();
//        Assert.assertEquals(90, pac.getIcon().getRotate(), 0);
//        pac.turnDown();
//        Assert.assertEquals(90, pac.getIcon().getRotate(), 0);
//
//    }
//
//    public void testMoveLeft() {
//
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveLeft(179);
//        Assert.assertEquals(-179, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveLeft(179);
//        Assert.assertEquals(-358, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//    }
//
//    public void testMoveRight() {
//
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveRight(179);
//        Assert.assertEquals(179, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveRight(179);
//        Assert.assertEquals(358, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//    }
//
//    public void testMoveUp() {
//
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveUp(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(-179, pac.getPoint().getY(), 0);
//        pac.moveUp(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(-358, pac.getPoint().getY(), 0);
//
//    }
//
////    @Test(expected = Exception.class)
//    public void testMoveDown() {
//
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveDown(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(179, pac.getPoint().getY(), 0);
//        pac.moveDown(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(358, pac.getPoint().getY(), 0);
//    }
//
//    public void testMoveDownMoveRight() {
//
//        // move down
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(0, pac.getPoint().getY(), 0);
//        pac.moveDown(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(179, pac.getPoint().getY(), 0);
//        pac.moveDown(179);
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(358, pac.getPoint().getY(), 0);
//
//        // move right
//        Assert.assertEquals(0, pac.getPoint().getX(), 0);
//        Assert.assertEquals(358, pac.getPoint().getY(), 0);
//        pac.moveRight(179);
//        Assert.assertEquals(179, pac.getPoint().getX(), 0);
//        Assert.assertEquals(358, pac.getPoint().getY(), 0);
//        pac.moveRight(179);
//        Assert.assertEquals(358, pac.getPoint().getX(), 0);
//        Assert.assertEquals(358, pac.getPoint().getY(), 0);
//    }
//
//    public void testGetCollider() {
//
//        Assert.assertTrue(pac.getCollider() != null && pac.getCollider() instanceof Shape);
//
//    }
//
//    public void testSetCollider() {
//    }
//
//    public void testGetIcon() {
//
//        Assert.assertTrue(pac.getIcon() != null && pac.getIcon() instanceof Shape);
//
//    }
//
//    public void testSetIcon() {
//    }
//
//    public void testGetPoint() {
//
//        Assert.assertTrue(pac.getPoint() != null && pac.getPoint() instanceof Point2D);
//
//    }
//
//    public void testSetPoint() {
//    }
//
//    public void testGetWidth() {
//
//        Assert.assertTrue( pac.getWidth() > 0);
//
//    }
//
//    public void testSetWidth() {
//
//        try {
//            pac.setWidth(0);
//            pac.setWidth(-40);
//            fail("Exception wasn't thrown!");
//        }
//        catch (IllegalArgumentException exception) {
////            assertEquals("lowerBound is bigger than upperBound!", exception.getMessage());
//        }
//    }
//
//    public void testGetHeight() {
//
//        Assert.assertTrue( pac.getHeight() > 0);
//
//    }
//
//    public void testSetHeight() {
//
//        try {
//            pac.setHeight(0);
//            pac.setHeight(-40);
//            fail("Exception wasn't thrown!");
//        }
//        catch (IllegalArgumentException exception) {
////            assertEquals("lowerBound is bigger than upperBound!", exception.getMessage());
//        }
//    }

    public void testCont() {
    }

    public void testInitPosition() {
    }
}