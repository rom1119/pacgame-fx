package com.pacgame.controller;

import com.pacgame.Controller;
import com.pacgame.Point;
import com.pacgame.model.Direction;
import com.pacgame.model.MapPoint;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import java.util.Timer;
import java.util.TimerTask;

public class PacmanController extends Controller implements EventHandler<KeyEvent> {

    public static final int SIZE = 6;

    protected Pacman controlledObject;
    protected SimpleStringProperty score;
    protected ObservableList<Point> allPoints;

    public PacmanController( Scene scene, Group root) {

        super(root);

        this.score = new SimpleStringProperty("0");

        this.controlledObject = (Pacman)new Pacman(new Point2D(0, 0), 13);
        scene.setOnKeyPressed(this);

        this.getControlledObject().getCollider().translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollision();
            }
        });

        this.getControlledObject().getCollider().translateYProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollision();
            }
        });

    }

    private void addScore(int score)
    {
        int allScore = Integer.parseInt(getScore());
        allScore = allScore + score;

        scoreProperty().set(String.valueOf(allScore));
    }

    public void initialize()
    {
        root.getChildren().add(getControlledObject().getCollider());
        root.getChildren().add(getControlledObject().getIcon());

        BidiMap allPoints = MapPathCreator.getAllPoints();
        movementManager = new MovementManager(allPoints, this.controlledObject, root);

        MapPoint currentPoint = (MapPoint) allPoints.get("h5");

        movementManager.setCurrentPoint(currentPoint);
        MapPoint newPoint = currentPoint.add(30, 0);

        this.score.setValue("0");
//
        this.getControlledObject().getIcon().setTranslateX(newPoint.getX());
        this.getControlledObject().getIcon().setTranslateY(newPoint.getY());

        this.getControlledObject().getCollider().setTranslateX(newPoint.getX());
        this.getControlledObject().getCollider().setTranslateY(newPoint.getY());

        this.getControlledObject().setPoint(newPoint);
//        this.objectToMove.initPosition();

        this.getControlledObject().setCheckedDirection(Direction.RIGHT);
        this.getControlledObject().turnRight();


    }

    public void setAllPoints(ObservableList<Point> allPoints) {
        this.allPoints = allPoints;
    }

    private void checkCollision() {
        boolean collisionDetected = false;
        for (Point point : allPoints) {
            if (point.getCollider() != this.getControlledObject().getCollider()) {
//                static_bloc.setFill(Color.GREEN);

                Shape intersect = Shape.intersect(this.getControlledObject().getCollider(), point.getCollider());
                if (intersect.getBoundsInLocal().getWidth() != -1) {
//                    collisionDetected = true;

                    if (point.isVisible()) {
                        point.getIcon().setFill(Color.TRANSPARENT);
                        addScore(point.getValue());
                        point.setVisible(false);
                    }

                }
            }
        }

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

    @Override
    public void startMove() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                movementManager.selectNextPoint();
                timer.cancel();
            }
        }, MovementManager.PERIOD_DELAY, 1);
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

    public String getScore() {
        return score.get();
    }

    public SimpleStringProperty scoreProperty() {
        return score;
    }
}
