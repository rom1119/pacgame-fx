package com.pacgame.service;

import com.pacgame.Component;
import com.pacgame.model.*;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import java.util.Timer;
import java.util.TimerTask;

public class MovementManager  implements EventHandler {

    private BidiMap mapPoints;
    private Player objectToMove;
    private Timeline animation;
    private MapPoint currentPoint;
    private Group root;
    private Path p;
    private Timer timer;
    private Shape elem ;
    private int currentDirection;
    private AnimationMoveHandler animationMoveEndHandler;
    private Label score;

    public void setScore(Label score) {
        this.score = score;
    }

    public static final int STEP_ANIMATE = 2;
    public static final int PERIOD_ANIMATE = 10;
    public static final int PERIOD_DELAY = 1000;
    public static final int SPEED_ANIMATE = 20;

//    private Player objectToMove;


    public MovementManager(BidiMap mapPoints, Player objectToMove, Group root) {
        this.mapPoints = mapPoints;
        this.objectToMove = objectToMove;
        this.root = root;
        this.elem = objectToMove.getCollider();


//        timer = new Timer();


    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public MapPoint getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(MapPoint currentPoint) {
        this.currentPoint = currentPoint;
    }

    public BidiMap getMapPoints() {
        return mapPoints;
    }

    public void setMapPoints(BidiMap mapPoints) {
        this.mapPoints = mapPoints;
    }

    public Player getObjectToMove() {
        return objectToMove;
    }

    public void setObjectToMove(Player objectToMove) {
        this.objectToMove = objectToMove;
    }

    public void positionUpdater()
    {

    }



    public void moveAnimate(int x, int y, Component objectToMove)
    {

        animation = new Timeline();
        animation.setOnFinished(this);


        KeyValue keyValueIconX = new KeyValue(objectToMove.getIcon().translateXProperty(), x, Interpolator.LINEAR);
        KeyValue keyValueIconY = new KeyValue(objectToMove.getIcon().translateYProperty(), y, Interpolator.LINEAR);

        KeyValue keyValueColliderX = new KeyValue(objectToMove.getCollider().translateXProperty(), x, Interpolator.LINEAR);
        KeyValue keyValueColliderY = new KeyValue(objectToMove.getCollider().translateYProperty(), y, Interpolator.LINEAR);

//        KeyFrame labelText = new KeyFrame(Duration.millis(calculateAnimationDuration()), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (score != null) {
//                    Platform.runLater(new Runnable() {
//                        public void run() {
//                            double translateYObject = getObjectToMove().getCollider().getTranslateX();
//                            double pointY = getObjectToMove().getIcon().getTranslateY();
//                            score.setText(String.valueOf("X = " + translateYObject + "Y = " + pointY));
//                        }
//                    });
//                }
//            }
//        });

        KeyFrame keyFrame = new KeyFrame(Duration.millis(calculateAnimationDuration()), keyValueIconX, keyValueIconY, keyValueColliderX, keyValueColliderY);



        animation.getKeyFrames().clear();
        animation.getKeyFrames().add(keyFrame);
//        animation.getKeyFrames().add(labelText);
        animation.setDelay(Duration.millis(0));

        animation.setCycleCount(1);
        animation.setAutoReverse(false);
        animation.play();

        this.getObjectToMove().setAnimated(true);


//        MoveTo moveTo = new MoveTo(currentPoint.getX(), currentPoint.getY());


//
    }

    public int calculateAnimationDuration()
    {

        if (this.getCurrentDirection() == Direction.UP  || this.getCurrentDirection() == Direction.DOWN) {
            double translateYObject = this.getObjectToMove().getCollider().getTranslateY();
            double pointY = this.getCurrentPoint().getY();

//            System.out.println(pointY - translateYObject);

            return (int) (SPEED_ANIMATE * Math.abs( translateYObject - pointY)) ;
        } else {
            double translateXObject = this.getObjectToMove().getCollider().getTranslateX();
            double pointX = this.getCurrentPoint().getX();
            return (int) (SPEED_ANIMATE * Math.abs( translateXObject - pointX)) ;
        }
    }

    public void stopAnimation()
    {
        animation.stop();
    }

    protected boolean canTurn(int direction)
    {
        switch (direction) {
            case Direction.UP :

                return getCurrentPoint().getUpPoint() != null;

            case Direction.DOWN :

                return getCurrentPoint().getDownPoint() != null;

            case Direction.LEFT :

                return getCurrentPoint().getLeftPoint() != null;

            case Direction.RIGHT :
                 return getCurrentPoint().getRightPoint() != null;

        }
        return false;

    }

    public void tryTurn(int direction)
    {
        if (canTurn(direction)) {
            this.setCurrentDirection(direction);
        }
    }

    public boolean turnBack()
    {
        if (animation == null) {
            return false;
        }
//        timer.cancel();
//        timer = new Timer();

        stopAnimation();

        if (this.isTurnedTo(Direction.UP)) {
            if (getCurrentPoint().getDownPoint() == null) {
                return false;
            }
            objectToMove.turnDown();
            objectToMove.setCheckedDirection(Direction.DOWN);
            this.setCurrentDirection(Direction.DOWN);
            this.currentPoint = getCurrentPoint().getDownPoint();
        } else if (this.isTurnedTo(Direction.DOWN)) {
            if (getCurrentPoint().getUpPoint() == null) {
                return false;
            }
            objectToMove.turnUp();
            objectToMove.setCheckedDirection(Direction.UP);
            this.setCurrentDirection(Direction.UP);
            this.currentPoint = getCurrentPoint().getUpPoint();
        } else if (this.isTurnedTo(Direction.LEFT)) {
            if (getCurrentPoint().getRightPoint() == null) {
                return false;
            }
            objectToMove.setCheckedDirection(Direction.RIGHT);
            this.setCurrentDirection(Direction.RIGHT);
            objectToMove.turnRight();
            this.currentPoint = getCurrentPoint().getRightPoint();
        } else {
            if (getCurrentPoint().getLeftPoint() == null) {
                return false;
            }
            objectToMove.turnLeft();
            objectToMove.setCheckedDirection(Direction.LEFT);
            this.setCurrentDirection(Direction.LEFT);
            this.currentPoint = getCurrentPoint().getLeftPoint();
        }

        objectToMove.setAnimated(false);
//        timer.cancel();
//        timer = null;
        run();

        return true;
    }

    public MapPoint getSelectedNextPoint()
    {
        return getCurrentPoint();
    }

    public boolean selectNextPoint()
    {
        if (getCurrentPoint() == null){
            return false;
        }

        this.tryTurn(objectToMove.getCheckedDirection());

        switch (this.getCurrentDirection()) {
            case Direction.UP :
                if (getCurrentPoint().getUpPoint() == null) {
                    return false;
                }
                this.currentPoint = getCurrentPoint().getUpPoint();
                break;
            case Direction.DOWN :
                if (getCurrentPoint().getDownPoint() == null) {
                    return false;
                }
                this.currentPoint = getCurrentPoint().getDownPoint();
                break;
            case Direction.LEFT :
                if (getCurrentPoint().getLeftPoint() == null) {
                    return false;
                }
                this.currentPoint = getCurrentPoint().getLeftPoint();
                break;
            case Direction.RIGHT :
                if (getCurrentPoint().getRightPoint() == null) {
                    return false;
                }
                this.currentPoint = getCurrentPoint().getRightPoint();
                break;
        }

//        MapPoint point = mapPoints.get()

//        System.out.println(mapPoints.getKey(this.currentPoint));
//        System.out.println(this.currentPoint);


        if (!objectToMove.isAnimated()) {
            run();
        }

        return true;
    }


    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handle(Event event) {

        this.getObjectToMove().setAnimated(false);
        animationEnd();
        selectNextPoint();
    }

    public boolean run()
    {
        if (getSelectedNextPoint() == null) {
//            animation.stop();
            return false;
        }

        MapPoint pointCurrent = getSelectedNextPoint();

        if (this.isTurnedTo(Direction.UP)) {
            objectToMove.turnUp();
        } else if (this.isTurnedTo(Direction.DOWN)) {
            objectToMove.turnDown();
        } else if (this.isTurnedTo(Direction.LEFT)) {
            objectToMove.turnLeft();
        } else if (this.isTurnedTo(Direction.RIGHT)) {

            objectToMove.turnRight();
        }

        moveAnimate((int) pointCurrent.getX(),(int)  pointCurrent.getY(), objectToMove);


        return true;
    }


    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public boolean isTurnedTo(int side) {
        return this.getCurrentDirection() == side;
    }

    private boolean animationEnd() {
        if (animationMoveEndHandler == null) {
            return false;
        }

        animationMoveEndHandler.animationMoveEnd(getCurrentPoint());

        return true;
    }

    public void setOnAnimationEnd(AnimationMoveHandler handler)
    {
        animationMoveEndHandler = handler;
    }
}
