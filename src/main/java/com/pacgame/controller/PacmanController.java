package com.pacgame.controller;

import com.pacgame.model.Direction;
import com.pacgame.model.Pacman;
import javafx.animation.KeyFrame;
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
    private Timeline fiveSecondsWonder;

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
        fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                that.run(2);
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }

    public void stopEatAnimation()
    {
        if (fiveSecondsWonder != null && fiveSecondsWonder instanceof Timeline){
            fiveSecondsWonder.stop();
        }
    }
}
