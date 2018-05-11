package com.pacgame.controller;

import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import org.apache.commons.collections.BidiMap;

public class MazeController {

    private Pacman pacman;
    private Timeline timeline;
    private MovementManager movementManager;
    private Group root;

    public MazeController(Scene scene, Group root) {

        this.pacman = new Pacman(new Point2D(0, 0), 13);
        this.root = root;
//        scene.setFocusTraversable(true);
//        scene.requestFocus();
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, this);

        BidiMap allPoints = MapPathCreator.getAllPoints();
//System.out.println("create");
        movementManager = new MovementManager(allPoints, this.pacman, root);
    }

    public void initialize()
    {
        root.getChildren().add(pacman.getCollider());
        root.getChildren().add(pacman.getIcon());
    }
}
