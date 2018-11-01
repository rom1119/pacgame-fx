package com.pacgame.board.service;

import com.pacgame.board.model.MapPoint;
import com.pacgame.board.model.Player;
import javafx.animation.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import java.util.Arrays;

public class MovementManager implements EventHandler {

    private BidiMap mapPoints;
    private Player objectToMove;
    private Timeline animation;
    private MapPoint currentPoint;
    private int currentDirection;
    private AnimationMoveHandler animationMoveEndHandler;
    private boolean canMoveInDoor = true;

    public static final int STEP_ANIMATE = 2;
    public static final int PERIOD_ANIMATE = 10;
    public static final int PERIOD_DELAY = 0;
    public static final String[] CENTER_POINTS = {
            "e5", "e5A", "e6"
    };

    public static boolean isInHeadquarters(MapPoint currentPoint)
    {
        return Arrays.asList(CENTER_POINTS).contains(currentPoint.getName());
    }

    public boolean isCanMoveInDoor() {
        return canMoveInDoor;
    }

    public void setCanMoveInDoor(boolean canMoveInDoor) {
        this.canMoveInDoor = canMoveInDoor;
    }

    //    private Player objectToMove;


    public MovementManager(BidiMap mapPoints, Player objectToMove, Group root) {
        this.mapPoints = mapPoints;
        this.objectToMove = objectToMove;

    }

    public int getSpeedMove() {
        return objectToMove.getSpeedMove();
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


    public void moveAnimate(int x, int y, Component objectToMove)
    {

        if (animation != null) {
            animation.pause();
        }
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

    public void changeSpeedAnimationMove()
    {
        if (animation == null) {
            return;
        }
        animation.pause();
        moveAnimate((int) getSelectedNextPoint().getX(), (int) getSelectedNextPoint().getY(), objectToMove);

    }

    public int calculateAnimationDuration()
    {

        if (this.getCurrentDirection() == Direction.UP  || this.getCurrentDirection() == Direction.DOWN) {
            double translateYObject = this.getObjectToMove().getCollider().getTranslateY();
            double pointY = this.getCurrentPoint().getY();

//            System.out.println(pointY - translateYObject);

            return (int) (getSpeedMove() * Math.abs( translateYObject - pointY)) ;
        } else {
            double translateXObject = this.getObjectToMove().getCollider().getTranslateX();
            double pointX = this.getCurrentPoint().getX();
            return (int) (getSpeedMove() * Math.abs( translateXObject - pointX)) ;
        }
    }

    public void stopAnimation()
    {
        if (animation != null) {
            animation.stop();
            animation = null;
        }
        getObjectToMove().setAnimated(false);
    }

    public void playAnimation()
    {
        if (animation != null) {
            animation.play();
            getObjectToMove().setAnimated(true);
        }
    }

    public void pauseAnimation()
    {
        if (animation != null) {
            animation.pause();
            getObjectToMove().setAnimated(false);
        }
    }

    protected boolean canTurn(int direction)
    {
        if (canMoveInDoor) {
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
        } else {
            switch (direction) {
                case Direction.UP :

                    return getCurrentPoint().getUpPoint() != null
                            &&
                            !getCurrentPoint().getUpPoint().isDoor();

                case Direction.DOWN :

                    return getCurrentPoint().getDownPoint() != null
                            &&
                            !getCurrentPoint().getDownPoint().isDoor();

                case Direction.LEFT :

                    return getCurrentPoint().getLeftPoint() != null
                            &&
                            !getCurrentPoint().getLeftPoint().isDoor();

                case Direction.RIGHT :
                    return getCurrentPoint().getRightPoint() != null
                            &&
                            !getCurrentPoint().getRightPoint().isDoor();

            }
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
            if (getCurrentPoint().getDownPoint() == null || getCurrentPoint().getDownPoint().isDoor()) {
                return false;
            }
            objectToMove.turnDown();
            objectToMove.setCheckedDirection(Direction.DOWN);
            this.setCurrentDirection(Direction.DOWN);
            this.currentPoint = getCurrentPoint().getDownPoint();
        } else if (this.isTurnedTo(Direction.DOWN)) {
            if (getCurrentPoint().getUpPoint() == null || getCurrentPoint().getUpPoint().isDoor()) {
                return false;
            }
            objectToMove.turnUp();
            objectToMove.setCheckedDirection(Direction.UP);
            this.setCurrentDirection(Direction.UP);
            this.currentPoint = getCurrentPoint().getUpPoint();
        } else if (this.isTurnedTo(Direction.LEFT)) {
            if (getCurrentPoint().getRightPoint() == null || getCurrentPoint().getRightPoint().isDoor()) {
                return false;
            }
            objectToMove.setCheckedDirection(Direction.RIGHT);
            this.setCurrentDirection(Direction.RIGHT);
            objectToMove.turnRight();
            this.currentPoint = getCurrentPoint().getRightPoint();
        } else {
            if (getCurrentPoint().getLeftPoint() == null || getCurrentPoint().getLeftPoint().isDoor()) {
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

    public boolean animationEnd() {
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
