package com.pacgame.service;

import com.pacgame.Component;
import com.pacgame.model.*;
import javafx.animation.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import org.apache.commons.collections.BidiMap;

import java.util.Timer;
import java.util.TimerTask;

public class MovementManager  implements EventHandler {

    private BidiMap mapPoints;
    private Player objectToMove;
    private PathTransition animation;
    private MapPoint currentPoint;
    private Group root;
    private Path p;
    private Timer timer;
    private Shape elem ;
    private int currentDirection;
    private AnimationMoveHandler animationMoveEndHandler;

    public static final int stepAnimate = 1;
    public static final int periodAnimate = 20;

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

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        }, 0, 25);
//        animation = new PathTransition();
////        p = new Path();
//
//        animation.setDuration(Duration.millis(3000));
//        animation.setNode(objectToMove.getIcon());
//
//        animation.setCycleCount(1);
//        animation.setAutoReverse(false);
//
//        //
//        MoveTo moveTo = new MoveTo(x - 1, y - 1);
////        MoveTo moveTo2 = new MoveTo(400, 100);
////        MoveTo moveTo3 = new MoveTo(100, 400);
//
//        LineTo lineTo = new LineTo(x, y);
////        LineTo lineTo1 = new LineTo(400, 400);
////        LineTo lineTo2 = new LineTo(100, 400);
////        LineTo lineTo3 = new LineTo(100, 100);
////        LineTo lineTo4 = new LineTo(400, 400);
//        p.getElements().clear();
//        p.getElements().add(moveTo);
//        p.getElements().add(lineTo);
//        animation.setPath(p);
////        animation.setNode();
//        animation.play();


//
//        animation = new Timeline();
//        animation.setOnFinished(this);
//
//
//        KeyValue keyValueIconX = new KeyValue(objectToMove.getIcon().translateXProperty(), x, Interpolator.LINEAR);
//        KeyValue keyValueIconY = new KeyValue(objectToMove.getIcon().translateYProperty(), y, Interpolator.LINEAR);
//
//        KeyValue keyValueColliderX = new KeyValue(objectToMove.getCollider().translateXProperty(), x, Interpolator.LINEAR);
//        KeyValue keyValueColliderY = new KeyValue(objectToMove.getIcon().translateYProperty(), y, Interpolator.LINEAR);
//
//
//        KeyFrame keyFrame = new KeyFrame(Duration.millis(2000), keyValueIconX, keyValueIconY, keyValueColliderX, keyValueColliderY);
//
//
////        animation.getKeyFrames().clear();
//        animation.getKeyFrames().add(keyFrame);
//        animation.setDelay(Duration.millis(0));
//
////        animation.setCycleCount(1);
////        animation.setAutoReverse(false);
//        animation.play();


//        MoveTo moveTo = new MoveTo(currentPoint.getX(), currentPoint.getY());


//
    }

    public void stopAnim()
    {
//        animation.stop();
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
        if (timer == null) {
            return false;
        }
        timer.cancel();
        timer = new Timer();

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

//        selectNextPoint();
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
            moveUp();
        } else if (this.isTurnedTo(Direction.DOWN)) {
            objectToMove.turnDown();
            moveDown();
        } else if (this.isTurnedTo(Direction.LEFT)) {
            objectToMove.turnLeft();
            moveLeft();
        } else if (this.isTurnedTo(Direction.RIGHT)) {

            objectToMove.turnRight();
            moveRight();
        }

//        moveAnimate((int) pointCurrent.getX(),(int)  pointCurrent.getY(), objectToMove);


        return true;
    }

    public void moveLeft()
    {
//        System.out.println(getCurrentPoint().getX());
//        System.out.println(elem.getTranslateX());
        baseAnimate(new TimerTask() {
           @Override
           public void run() {
               if ((int)(elem.getTranslateX() ) <= (int)getCurrentPoint().getX()) {
                   objectToMove.setAnimated(false);
                   timer.cancel();
                   animationEnd();
                   selectNextPoint();
               }
//               System.out.println("left");

               objectToMove.moveLeft(stepAnimate);

           }
       });
    }

    public void moveRight()
    {
        baseAnimate(new TimerTask() {
            @Override
            public void run() {
                if ((int)elem.getTranslateX() >= (int)getCurrentPoint().getX()) {
                    objectToMove.setAnimated(false);
                    timer.cancel();
                    animationEnd();
                    selectNextPoint();
                }
//                System.out.println("right");

                objectToMove.moveRight(stepAnimate);

            }
        });
    }

    public void moveUp()
    {
        baseAnimate(new TimerTask() {
            @Override
            public void run() {

                if ((int)elem.getTranslateY() <= (int)getCurrentPoint().getY()) {
                    objectToMove.setAnimated(false);
                    timer.cancel();
                    animationEnd();
                    selectNextPoint();
                }
//                System.out.println("up");

                objectToMove.moveUp(stepAnimate);

            }
        });
    }

    public void moveDown()
    {
        baseAnimate(new TimerTask() {
            @Override
            public void run() {
                if ((int)elem.getTranslateY() >= (int)getCurrentPoint().getY()) {
                    objectToMove.setAnimated(false);
                    timer.cancel();
                    animationEnd();
                    selectNextPoint();
                }
//                System.out.println("down");

                objectToMove.moveDown(stepAnimate);

            }
        });
    }

    public boolean baseAnimate(TimerTask task)
    {
        if (objectToMove.isAnimated()) {
            return false;
        }
        objectToMove.setAnimated(true);
        timer = null;
        timer = new Timer();
        timer.schedule(task, 0, periodAnimate);

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
