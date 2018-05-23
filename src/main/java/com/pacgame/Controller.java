package com.pacgame;

import com.pacgame.model.Pacman;
import com.pacgame.model.Player;
import com.pacgame.service.MovementManager;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class Controller {

    protected Player controlledObject;
    protected Timeline timeline;
    protected MovementManager movementManager;
    protected Group root;

    public Controller(Group root) {

        this.root = root;

    }

    public Player getControlledObject() {
        return controlledObject;
    }

    public void setControlledObject(Pacman controlledObject) {
        this.controlledObject = controlledObject;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
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

    public abstract void initialize();
    public abstract void startMove();
}
