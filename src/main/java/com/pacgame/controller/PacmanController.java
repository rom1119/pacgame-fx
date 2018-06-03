package com.pacgame.controller;

import com.pacgame.App;
import com.pacgame.Controller;
import com.pacgame.Point;
import com.pacgame.event.MazeEvent;
import com.pacgame.event.PointEvent;
import com.pacgame.Direction;
import com.pacgame.model.MapPoint;
import com.pacgame.model.Maze;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import java.util.Timer;
import java.util.TimerTask;

public class PacmanController extends Controller implements EventHandler<KeyEvent> {

    public static final int SIZE = 24;

    protected Pacman controlledObject;
    protected SimpleStringProperty score;
    protected ObservableList<Point> allPoints;
    private ObservableList<MazeController> mazeControllerList;

    public PacmanController( Scene scene, Group root) {

        super(root);

        this.score = new SimpleStringProperty("0");

        this.controlledObject = new Pacman(new Point2D(0, 0), SIZE / 2);
        scene.setOnKeyPressed(this);

    }

    private void setOnPacmanMove()
    {
        this.getControlledObject().getCollider().translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollisionPoints();
            }
        });

        this.getControlledObject().getCollider().translateYProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollisionPoints();
            }
        });
    }

    public void addScore(int score)
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
        movementManager.setCanMoveInDoor(false);


        this.score.setValue("0");
        this.getControlledObject().setLives(String.valueOf(Pacman.INITIAL_LIVES));
//
        setInitPosition();

        this.setOnPacmanMove();


    }

    public void setInitPosition()
    {
        BidiMap allPoints = MapPathCreator.getAllPoints();
        MapPoint currentPoint = (MapPoint) allPoints.get("h5A");

        movementManager.setCurrentPoint(currentPoint);
        MapPoint newPoint = currentPoint;

        this.getControlledObject().setPoint(newPoint);
        this.getControlledObject().updatePosition();

        this.getControlledObject().setCheckedDirection(Direction.RIGHT);
        this.getControlledObject().turnRight();

        getMovementManager().stopAnimation();
//        getMovementManager().setCurrentPoint(newPoint);
        startMove();

    }

    public void setAllPoints(ObservableList<Point> allPoints) {
        this.allPoints = allPoints;
    }



    private void checkCollisionPoints() {
        for (Point point : allPoints) {
            Shape intersect = Shape.intersect(this.getControlledObject().getCollider(), point.getCollider());
            if (intersect.getBoundsInLocal().getWidth() != -1) {

                PointEvent pointEvent = new PointEvent(PointEvent.DESTROY);
                pointEvent.setPoint(point);
                pointEvent.setPacmanController(this);
                pointEvent.setMazeControllerList(getMazeControllerList());
                point.getCollider().fireEvent(pointEvent);


            }
        }

    }

    public ObservableList<MazeController> getMazeControllerList() {
        return mazeControllerList;
    }

    public void setMazeControllerList(ObservableList<MazeController> mazeControllerList) {
        this.mazeControllerList = mazeControllerList;
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

        if (!App.isRunning()) {
            return;
        }
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
        KeyFrame actionsOnTime = new KeyFrame(Duration.millis(MovementManager.PERIOD_DELAY), new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        });


        initTimer = new Timeline();

        initTimer.getKeyFrames().clear();
        initTimer.getKeyFrames().add(actionsOnTime);
        initTimer.setDelay(Duration.millis(0));

        initTimer.setCycleCount(1);
        initTimer.setAutoReverse(false);
        initTimer.play();

        initTimer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (movementManager != null) {
                    movementManager.selectNextPoint();
                }
            }
        });
    }

    public void playInitTimer()
    {
        if (initTimer != null) {
            initTimer.play();
        }
    }

    public void pauseInitTimer()
    {
        if (initTimer != null) {
            initTimer.pause();
        }
    }


    public void startEatAnimation()
    {
        final PacmanController that = this;
        mainAnimation = new Timeline();

        KeyValue keyValueAngle = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 0);
        KeyValue keyValueLength = new KeyValue(getControlledObject().getIcon().lengthProperty(), 360);
        KeyValue keyValueCenterX = new KeyValue(getControlledObject().getIcon().centerXProperty(), -3);
        KeyValue keyValueCenterY = new KeyValue(getControlledObject().getIcon().centerYProperty(), -3);
//        KeyValue keyValueStart = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 45);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValueAngle, keyValueLength, keyValueCenterX, keyValueCenterY);

        mainAnimation.getKeyFrames().add(keyFrame);

        mainAnimation.setCycleCount(Timeline.INDEFINITE);
        mainAnimation.setAutoReverse(true);
        mainAnimation.play();
    }

    public void stopEatAnimation()
    {
        if (getMainAnimation() != null){
            getMainAnimation().stop();
        }
    }

    public void subtractLive()
    {
        int actualLives = Integer.parseInt(getControlledObject().getLives());
        actualLives--;
        getControlledObject().setLives(String.valueOf(actualLives));
    }

    public String getScore() {
        return score.get();
    }

    public SimpleStringProperty scoreProperty() {
        return score;
    }
}
