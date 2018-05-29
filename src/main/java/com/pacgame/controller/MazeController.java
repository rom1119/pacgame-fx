package com.pacgame.controller;

import com.pacgame.Controller;
import com.pacgame.model.*;
import com.pacgame.service.AI;
import com.pacgame.service.AnimationMoveHandler;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import org.apache.commons.collections.BidiMap;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MazeController extends Controller implements AnimationMoveHandler  {

    public static final int SIZE = 24;
    public static final int MAX_AMOUNT_MAZES = 10;
    private boolean isMovedByAI = true;
    public static final String[] CENTER_POINTS = {
            "e5", "e5A", "e6"
    };

    protected AI finderObject;
    private Timeline stateTimeline;

    public MazeController( Group root) {

        super(root);
        int min = 1;
        int max = 2;
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;

        this.controlledObject = createNewMaze(randomNumber);
        this.root = root;

        getControlledObject().getIcon().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("direction maze: " + getControlledObject().getCheckedDirection());
//                System.out.println("direction manager: " + getMovementManager().getCurrentDirection());
//                System.out.println("current point manager: " + getMovementManager().getCurrentPoint());
//                System.out.println("timer: " + getMovementManager().getTimer());
//                System.out.println("isAnimated: " + getControlledObject().isAnimated());
            }
        });

    }

    public Maze createNewMaze(int type)
    {
        switch (type) {
            case 1:
                return new RedMaze(new Point2D(0, 0), SIZE, SIZE);
            case 2:
                return new AquaMaze(new Point2D(0, 0), SIZE, SIZE);
            default:
                return new RedMaze(new Point2D(0, 0), SIZE, SIZE);
        }
    }

    public void initialize()
    {
        root.getChildren().add(getControlledObject().getCollider());
        root.getChildren().add(getControlledObject().getIcon());

        BidiMap allPoints = MapPathCreator.getAllPoints();
        movementManager = new MovementManager(allPoints, this.controlledObject, root);

        MapPoint currentPoint = (MapPoint) allPoints.get("e5");

        movementManager.setCurrentPoint(currentPoint);
        movementManager.setOnAnimationEnd(this);

        MapPoint newPoint = currentPoint;

//        this.getControlledObject().getIcon().setTranslateX(newPoint.getX());
//        this.getControlledObject().getIcon().setTranslateY(newPoint.getY());
//
//        this.getControlledObject().getCollider().setTranslateX(newPoint.getX());
//        this.getControlledObject().getCollider().setTranslateY(newPoint.getY());

        this.getControlledObject().setPoint(newPoint);
        this.getControlledObject().initPosition();

        this.getControlledObject().setCheckedDirection(Direction.RIGHT);
        this.getControlledObject().turnRight();



    }

    public void initFinder(PacmanController pacmanController)
    {
        this.finderObject = new AI(this, pacmanController);
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

    @Override
    public void animationMoveEnd(MapPoint currentPoint)
    {
        if (!isMovedByAI()) {
            setRandomDirection(currentPoint);
        } else {
            boolean directionFromAI = false;
            if (!Arrays.asList(CENTER_POINTS).contains(this.getMovementManager().getCurrentPoint().getName())) {
                directionFromAI = finderObject.selectNextDirection();
            }

            if (!directionFromAI) {
                setRandomDirection(currentPoint);
            }
        }


    }

    private void setRandomDirection(MapPoint currentPoint)
    {
        int min = 0;
        int max = 3;
        MapPoint selectedMapPoint = null;

        do {
            Random random = new Random();
            int randomNumber = random.nextInt(max + 1 - min) + min;

//            System.out.println(randomNumber);


            switch (randomNumber) {
                case Direction.UP :
                    if (currentPoint.getUpPoint() != null) {
                        selectedMapPoint = currentPoint.getUpPoint();
                        getControlledObject().setCheckedDirection(Direction.UP);
                    }
                    break;
                case Direction.DOWN :
                    if (currentPoint.getDownPoint() != null) {
                        selectedMapPoint = currentPoint.getDownPoint();
                        getControlledObject().setCheckedDirection(Direction.DOWN);
                    }
                    break;
                case Direction.LEFT :
                    if (currentPoint.getLeftPoint() != null) {
                        selectedMapPoint = currentPoint.getLeftPoint();
                        getControlledObject().setCheckedDirection(Direction.LEFT);
                    }
                    break;
                case Direction.RIGHT :
                    if (currentPoint.getRightPoint() != null) {
                        selectedMapPoint = currentPoint.getRightPoint();
                        getControlledObject().setCheckedDirection(Direction.RIGHT);
                    }
                    break;
            }

        } while (selectedMapPoint == null);
    }

    public boolean isMovedByAI() {
        return isMovedByAI;
    }

    public void setMovedByAI(boolean movedByAI) {
        isMovedByAI = movedByAI;
    }

    public Timeline getStateTimeline() {
        return stateTimeline;
    }

    public void setStateTimeline(Timeline stateTimeline) {
        this.stateTimeline = stateTimeline;
    }
}
