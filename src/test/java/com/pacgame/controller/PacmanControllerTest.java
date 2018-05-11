package com.pacgame.controller;

import com.pacgame.model.Direction;
import com.pacgame.model.Pacman;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import junit.framework.TestCase;
import org.junit.Assert;

public class PacmanControllerTest extends TestCase {

    private Pacman pacman;
    private PacmanController pacmanController;

    public void setUp() throws Exception {
        super.setUp();

        Group root = new Group();

        pacmanController = new PacmanController( new Scene(new Group()), root);
//        pacmanController.initialize();
    }

    public void tearDown() throws Exception {
    }

    public void testHandleException() {

        try {
            pacman.setCheckedDirection(4);
            pacman.setCheckedDirection(-1);
            fail("Exception wasn't thrown!");
        }
        catch (IllegalArgumentException exception) {
//            assertEquals("lowerBound is bigger than upperBound!", exception.getMessage());
        }
    }

    public void testHandle() {

        pacman.setCheckedDirection(Direction.UP);
        Assert.assertEquals(0, pacman.getCheckedDirection(), 0);
        pacman.setCheckedDirection(Direction.DOWN);
        Assert.assertEquals(1, pacman.getCheckedDirection(), 0);
        pacman.setCheckedDirection(Direction.LEFT);
        Assert.assertEquals(2, pacman.getCheckedDirection(), 0);
        pacman.setCheckedDirection(Direction.RIGHT);
        Assert.assertEquals(3, pacman.getCheckedDirection(), 0);

    }
//
//    public void testRun() {
//
//        assertEquals(270, (int)pacman.getIcon().getRotate());
//        assertEquals(270, (int)pacman.getCollider().getRotate());
//        pacmanController.run(19);
//
//        assertEquals(270, (int)pacman.getIcon().getRotate());
//        assertEquals(270, (int)pacman.getCollider().getRotate());
//        assertEquals(0, (int)pacman.getPoint().getX());
//        assertEquals(-19, (int)pacman.getPoint().getY());
//
//        pacman.turnRight();
//        pacman.setCheckedDirection(Direction.RIGHT);
//        pacmanController.run(19);
//        pacman.turnRight();
//        pacman.setCheckedDirection(Direction.RIGHT);
//        pacmanController.run(19);
//
//        assertEquals(0, (int)pacman.getIcon().getRotate());
//        assertEquals(0, (int)pacman.getCollider().getRotate());
//        assertEquals(38, (int)pacman.getPoint().getX());
//        assertEquals(-19, (int)pacman.getPoint().getY());
//
//        pacman.turnDown();
//        pacman.setCheckedDirection(Direction.DOWN);
//        pacmanController.run(19);
//        pacmanController.run(19);
//        pacmanController.run(19);
//
//        assertEquals(90, (int)pacman.getIcon().getRotate());
//        assertEquals(90, (int)pacman.getCollider().getRotate());
//        assertEquals(38, (int)pacman.getPoint().getX());
//        assertEquals(38, (int)pacman.getPoint().getY());
//
//
//
//
//
//    }
}