package com.pacgame.board.controller;

import com.pacgame.App;
import com.pacgame.Controller;
import com.pacgame.Direction;
import com.pacgame.board.model.*;
import com.pacgame.board.event.MazeEvent;
import com.pacgame.board.event.eventHandler.OnDestroyBigPoint;
import com.pacgame.board.service.AI;
import com.pacgame.board.service.AnimationMoveHandler;
import com.pacgame.board.service.MapPathCreator;
import com.pacgame.board.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import java.util.Random;

public class MazeController extends Controller implements AnimationMoveHandler  {

    public static final int SIZE = 24;
    public static final int MAX_AMOUNT_MAZES = 10;
    private boolean isMovedByAI = true;
    private String name;

    protected AI finderObject;
    protected PacmanController pacmanController;
    private Timeline stateTimeline;

    public String getName() {
        return name;
    }

    public MazeController(Group root) {
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

    private void setOnPacmanMove()
    {
        if (getPacmanController() == null) {
            throw new NullPointerException("Pacman Controller must be set to run this method");
        }

        this.getControlledObject().getCollider().translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollisionPacman();
            }
        });

        this.getControlledObject().getCollider().translateYProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                checkCollisionPacman();
            }
        });
    }

    private void checkCollisionPacman() {
        if (getPacmanController() == null || getControlledObject() == null) {
            return;
        }
        Pacman pacman = (Pacman) getPacmanController().getControlledObject();
        Shape intersect = Shape.intersect(this.getControlledObject().getCollider(), pacman.getCollider());
        if (intersect.getBoundsInLocal().getWidth() >= 5 && intersect.getBoundsInLocal().getHeight() >= 5) {

            MazeEvent mazeEvent = new MazeEvent(MazeEvent.TOUCH);
            mazeEvent.setRoot(getRoot());
            mazeEvent.setMazeController(this);
            mazeEvent.setPacmanController(pacmanController);
            this.getControlledObject().getCollider().fireEvent(mazeEvent);


        }

    }

    public void initialize()
    {
        root.getChildren().add(App.indexForMaze - 2, getControlledObject().getCollider());
        root.getChildren().add(App.indexForMaze - 2, getControlledObject().getIcon());

        BidiMap allPoints = MapPathCreator.getAllPoints();
        movementManager = new MovementManager(allPoints, this.controlledObject, root);

        MapPoint currentPoint = (MapPoint) allPoints.get("e5");

        movementManager.setCurrentPoint(currentPoint);
        movementManager.setOnAnimationEnd(this);

        MapPoint newPoint = currentPoint;

        stateTimeline = new Timeline();

//        this.getControlledObject().getIcon().setTranslateX(newPoint.getX());
//        this.getControlledObject().getIcon().setTranslateY(newPoint.getY());
//
//        this.getControlledObject().getCollider().setTranslateX(newPoint.getX());
//        this.getControlledObject().getCollider().setTranslateY(newPoint.getY());

        this.getControlledObject().setPoint(newPoint);
        this.getControlledObject().initPosition();

        this.getControlledObject().setCheckedDirection(Direction.RIGHT);
        this.getControlledObject().turnRight();

        this.setOnPacmanMove();



    }

    public void initFinder(PacmanController pacmanController)
    {
        this.finderObject = new AI(this, pacmanController);
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
                if (movementManager != null && !getControlledObject().isSelectFirstPoint()) {
                    movementManager.selectNextPoint();
                    getControlledObject().setSelectFirstPoint(true);
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

    @Override
    public void animationMoveEnd(MapPoint currentPoint)
    {

//                System.out.println(currentPoint.getName());
        if (!isMovedByAI()) {
            setRandomDirection(currentPoint);
        } else {
            boolean directionFromAI = false;
            Maze maze = (Maze) getControlledObject();
            if (maze.isGhost() ) {
                if (this.getMovementManager().getCurrentPoint().getName().equals("d5A")) {
                    directionFromAI = finderObject.selectNextDirectionToInitPosition("e5A");

                } else if (this.getMovementManager().getCurrentPoint().getName().equals("e5A")) {
                    directionFromAI = finderObject.selectNextDirectionToInitPosition("e6");

                } else if (this.getMovementManager().getCurrentPoint().getName().equals("e6")) {
                    int currentSpeed = maze.getSpeedMove();
                    maze.speedMoveProperty().set(currentSpeed - OnDestroyBigPoint.SPEED_MULTIPLIER);
                    ((Maze) getControlledObject()).setGhost(false);
                    ((Maze) getControlledObject()).updateIcon();
                    finderObject.zeroSteps();
                    directionFromAI = finderObject.selectNextDirectionToPacman();
                } else {
                    directionFromAI = finderObject.selectNextDirectionToInitPosition("d5A");

                }
            } else {
                if (!MovementManager.isInHeadquarters(currentPoint)) {
                    directionFromAI = finderObject.selectNextDirectionToPacman();
                }

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
        boolean isSelectedMapPoint = false;

        do {
            Random random = new Random();
            int randomNumber = random.nextInt(max + 1 - min) + min;

//            System.out.println(randomNumber);

            if (MovementManager.isInHeadquarters(getMovementManager().getCurrentPoint())) {
                switch (randomNumber) {
                    case Direction.UP :
                        if (currentPoint.getUpPoint() != null) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.UP);
                        }
                        break;
                    case Direction.DOWN :
                        if (currentPoint.getDownPoint() != null) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.DOWN);
                        }
                        break;
                    case Direction.LEFT :
                        if (currentPoint.getLeftPoint() != null) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.LEFT);
                        }
                        break;
                    case Direction.RIGHT :
                        if (currentPoint.getRightPoint() != null) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.RIGHT);
                        }
                        break;
                }
            } else {
                switch (randomNumber) {
                    case Direction.UP :
                        if (currentPoint.getUpPoint() != null && !currentPoint.getUpPoint().isDoor()) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.UP);
                        }
                        break;
                    case Direction.DOWN :
                        if (currentPoint.getDownPoint() != null && !currentPoint.getDownPoint().isDoor()) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.DOWN);
                        }
                        break;
                    case Direction.LEFT :
                        if (currentPoint.getLeftPoint() != null && !currentPoint.getLeftPoint().isDoor()) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.LEFT);
                        }
                        break;
                    case Direction.RIGHT :
                        if (currentPoint.getRightPoint() != null && !currentPoint.getRightPoint().isDoor()) {
                            isSelectedMapPoint = true;
                            getControlledObject().setCheckedDirection(Direction.RIGHT);
                        }
                        break;
                }
            }


        } while (!isSelectedMapPoint);
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

    public void playStateTimeline()
    {
        if (getStateTimeline() != null) {
            getStateTimeline().play();
        }
    }

    public void pauseStateTimeline()
    {
        if (getStateTimeline() != null) {
            getStateTimeline().pause();
        }
    }

    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }
}
