package com.pacgame.controller;

import com.pacgame.model.Direction;
import com.pacgame.model.Pacman;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class PacmanController implements EventHandler<KeyEvent> {

    private Pacman pacman;
    private Timeline timeline;

    public PacmanController(Pacman pacman, Scene scene) {

        this.pacman = pacman;
//        scene.setFocusTraversable(true);
//        scene.requestFocus();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this);
        scene.setOnKeyReleased(this);
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
                pacman.setCheckedDirection(Direction.UP);
                break;
            case RIGHT:
                pacman.setCheckedDirection(Direction.RIGHT);
                break;
            case DOWN:
                pacman.setCheckedDirection(Direction.DOWN);
                break;
            case LEFT:
                pacman.setCheckedDirection(Direction.LEFT);
                break;
        }


    }

    public void run(int step)
    {
        if (pacman.isTurnedTo(Direction.UP)) {
            pacman.moveUp(step);
            pacman.turnUp();
        } else if (pacman.isTurnedTo(Direction.DOWN)) {
            pacman.moveDown(step);
            pacman.turnDown();
        } else if (pacman.isTurnedTo(Direction.LEFT)) {
            pacman.moveLeft(step);
            pacman.turnLeft();
        } else {
            pacman.moveRight(step);
            pacman.turnRight();
        }
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

        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValueAngle, keyValueLength, keyValueCenterX, keyValueCenterY);

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
