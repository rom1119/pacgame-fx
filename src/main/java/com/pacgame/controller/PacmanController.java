package com.pacgame.controller;

import com.pacgame.model.Direction;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

public class PacmanController implements EventHandler<KeyEvent> {

    private Pacman pacman;
    private Timeline timeline;
    private MovementManager movementManager;
    private Group root;

    public PacmanController(Pacman pacman, Scene scene, Group root) {

        this.pacman = pacman;
        this.root = root;
//        scene.setFocusTraversable(true);
//        scene.requestFocus();
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, this);
        scene.setOnKeyPressed(this);

        BidiMap allPoints = MapPathCreator.getAllPoints();
//System.out.println("create");
        movementManager = new MovementManager(allPoints, this.pacman, root);
    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handle(KeyEvent event) {

        switch (event.getCode()) {
            case UP:
                if (pacman.isTurnedTo(Direction.DOWN)) {
                    movementManager.turnBack();
                    break;
                }
                pacman.setCheckedDirection(Direction.UP);
                if (!pacman.isAnimated()) {
                    movementManager.selectNextPoint();
                }

                break;
            case RIGHT:
                if (pacman.isTurnedTo(Direction.LEFT)) {
                    movementManager.turnBack();
                    break;
                }
                pacman.setCheckedDirection(Direction.RIGHT);
                if (!pacman.isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case DOWN:
                if (pacman.isTurnedTo(Direction.UP)) {
                    movementManager.turnBack();
                    break;
                }
                pacman.setCheckedDirection(Direction.DOWN);
                if (!pacman.isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case LEFT:
                if (pacman.isTurnedTo(Direction.RIGHT)) {
                    movementManager.turnBack();
                    break;
                }
                pacman.setCheckedDirection(Direction.LEFT);
                if (!pacman.isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
        }


    }

    public void startMove()
    {
        movementManager.selectNextPoint();
    }


    public void startEatAnimation()
    {
        final PacmanController that = this;
        timeline = new Timeline();

        KeyValue keyValueAngle = new KeyValue(pacman.getIcon().startAngleProperty(), 0);
        KeyValue keyValueLength = new KeyValue(pacman.getIcon().lengthProperty(), 360);
        KeyValue keyValueCenterX = new KeyValue(pacman.getIcon().centerXProperty(), -3);
        KeyValue keyValueCenterY = new KeyValue(pacman.getIcon().centerYProperty(), -3);
//        KeyValue keyValueStart = new KeyValue(pacman.getIcon().startAngleProperty(), 45);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValueAngle, keyValueLength, keyValueCenterX, keyValueCenterY);

        timeline.getKeyFrames().add(keyFrame);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }

    public void stopEatAnimation()
    {
        if (timeline != null && timeline instanceof Timeline){
            timeline.stop();
        }
    }
}
