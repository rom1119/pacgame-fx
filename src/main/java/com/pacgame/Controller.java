package com.pacgame;

import com.pacgame.model.Pacman;
import com.pacgame.model.Player;
import com.pacgame.service.MovementManager;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class Controller {

    protected Player controlledObject;
    protected Timeline mainAnimation;
    protected MovementManager movementManager;
    protected Group root;
    protected Timeline initTimer;

    public Controller(Group root) {

        this.root = root;

    }

    public Player getControlledObject() {
        return controlledObject;
    }

    public void playMainAnimation()
    {
        if (mainAnimation != null) {
            mainAnimation.play();
        }
    }

    public void pauseMainAnimation()
    {
        if (mainAnimation != null) {
            mainAnimation.pause();
        }
    }

    public void setControlledObject(Pacman controlledObject) {
        this.controlledObject = controlledObject;
    }

    public MovementManager getMovementManager() {
        return movementManager;
    }

    public void setMovementManager(MovementManager movementManager) {
        this.movementManager = movementManager;
    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public Timeline getMainAnimation() {
        return mainAnimation;
    }

    public void setMainAnimation(Timeline mainAnimation) {
        this.mainAnimation = mainAnimation;
    }

    public Timeline getInitTimer() {
        return initTimer;
    }

    public void setInitTimer(Timeline initTimer) {
        this.initTimer = initTimer;
    }

    public abstract void initialize();
    public abstract void startMove();
}
