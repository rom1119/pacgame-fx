package com.pacgame.controller;

import com.pacgame.model.*;
import com.pacgame.service.AnimationMoveHandler;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.MovementManager;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import org.apache.commons.collections.BidiMap;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MazeController extends Controller implements AnimationMoveHandler  {

    public static final int SIZE = 24;


    public MazeController(Scene scene, Group root) {

        super(scene, root);
        int min = 1;
        int max = 2;
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;

        this.controlledObject = createNewMaze(randomNumber);
        this.root = root;

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

    @Override
    public void startMove() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                movementManager.selectNextPoint();
                timer.cancel();
            }
        }, 1000, 1);
    }

    @Override
    public void animationMoveEnd(MapPoint currentPoint) {
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


}
