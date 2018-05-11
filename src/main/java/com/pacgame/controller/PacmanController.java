package com.pacgame.controller;

import com.pacgame.model.Direction;
import com.pacgame.model.Pacman;
import com.pacgame.model.Player;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

public class PacmanController extends Controller implements EventHandler<KeyEvent> {

    protected Pacman controlledObject;

    public PacmanController( Scene scene, Group root) {

        super(scene, root);

        this.controlledObject = (Pacman)new Pacman(new Point2D(0, 0), 13);
        scene.setOnKeyPressed(this);

    }

    public void initialize()
    {
        root.getChildren().add(getControlledObject().getCollider());
        root.getChildren().add(getControlledObject().getIcon());

        BidiMap allPoints = MapPathCreator.getAllPoints();
        movementManager = new MovementManager(allPoints, this.controlledObject, root);

    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    @Override
    public Pacman getControlledObject() {
        return controlledObject;
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
                if (getControlledObject().isTurnedTo(Direction.DOWN)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.UP);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }

                break;
            case RIGHT:
                if (getControlledObject().isTurnedTo(Direction.LEFT)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.RIGHT);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case DOWN:
                if (getControlledObject().isTurnedTo(Direction.UP)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.DOWN);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case LEFT:
                if (getControlledObject().isTurnedTo(Direction.RIGHT)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.LEFT);
                if (!getControlledObject().isAnimated()) {
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

        KeyValue keyValueAngle = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 0);
        KeyValue keyValueLength = new KeyValue(getControlledObject().getIcon().lengthProperty(), 360);
        KeyValue keyValueCenterX = new KeyValue(getControlledObject().getIcon().centerXProperty(), -3);
        KeyValue keyValueCenterY = new KeyValue(getControlledObject().getIcon().centerYProperty(), -3);
//        KeyValue keyValueStart = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 45);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValueAngle, keyValueLength, keyValueCenterX, keyValueCenterY);

        timeline.getKeyFrames().add(keyFrame);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }

    public void stopEatAnimation()
    {
        if (timeline != null){
            timeline.stop();
        }
    }
}
