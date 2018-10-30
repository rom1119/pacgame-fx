package com.pacgame.board.service;

import com.pacgame.App;
import com.pacgame.Direction;
import com.pacgame.board.Controller;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.board.model.MapPoint;
import com.pacgame.board.model.SpecialAction.SpecialAction;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MirrorDoorEffect extends SpecialAction {

    private MapPoint firstMapPoint = (MapPoint) MapPathCreator.getAllPoints().get("e1");
    private MapPoint reflectiveMapPoint = (MapPoint) MapPathCreator.getAllPoints().get("e10");
    private int OFFSET_LEFT = 40;
    private int OFFSET_RIGHT = 50;
    private Controller cloneObjectToModify;

    public MirrorDoorEffect(Controller objectToModify) {
        super(objectToModify);
    }

    @Override
    public boolean isClone()
    {
        return getObjectControllerToModify() != App.getPacmanController();
    }

    @Override
    public void backAction()
    {
        if (getObjectControllerToModify().getControlledObject().isTurnedTo(Direction.RIGHT)) {
            goBackToFirstMapPoint(null);
        } else if (getObjectControllerToModify().getControlledObject().isTurnedTo(Direction.LEFT)) {
            goBackToReflectiveMapPoint(null);
        }
    }

    @Override
    public boolean tryStartAction()
    {
        return goToReflectDoor(getObjectControllerToModify().getMovementManager());

    }

    private boolean goToReflectDoor(MovementManager movementManager) {
//        System.out.println(firstMapPoint.getX());
        if (movementManager.getObjectToMove().isAnimated()) {
            return false;
        }

        if (movementManager.getCurrentPoint().equals(firstMapPoint)) {
           goThroughFirstMapPoint(movementManager);
           return true;
        }
        else if (movementManager.getCurrentPoint().equals(reflectiveMapPoint)) {
            goThroughReflcetiveMapPoint(movementManager);
            return true;
        }

        return false;
    }

    private void goThroughFirstMapPoint(MovementManager movementManager)
    {
        if (getObjectControllerToModify().getControlledObject().isTurnedTo(Direction.LEFT)) {
            goByFirstMapPoint(movementManager);

        }
    }

    private void goThroughReflcetiveMapPoint(MovementManager movementManager)
    {
        if (getObjectControllerToModify().getControlledObject().isTurnedTo(Direction.RIGHT)) {
            goByReflectiveMapPoint(movementManager);

        }
    }

    private void goBackToFirstMapPoint(MovementManager movementManager) {
        if (getCloneObjectToModify() == null) {
            return;
        }
//        App.stopPacmanController((PacmanController) getCloneObjectToModify());
        getCloneObjectToModify().getMovementManager().stopAnimation();
        Timeline timeline = getCloneObjectToModify().getMovementManager().moveAnimate((int) reflectiveMapPoint.getX() + OFFSET_RIGHT, (int) reflectiveMapPoint.getY(), getCloneObjectToModify().getControlledObject());
            System.out.println("asd");
        timeline.setOnFinished(e -> {
            App.stopPacmanController((PacmanController) getCloneObjectToModify());
            ((PacmanController) getCloneObjectToModify()).deinitialize();
            setCloneObjectToModify(null);

        });
    }

    private void goBackToReflectiveMapPoint(MovementManager movementManager) {
        if (getCloneObjectToModify() == null) {
            return;
        }
        App.stopPacmanController((PacmanController) getCloneObjectToModify());

        Timeline timeline = getCloneObjectToModify().getMovementManager().moveAnimate((int) firstMapPoint.getX() + OFFSET_LEFT, (int) firstMapPoint.getY(), getCloneObjectToModify().getControlledObject());
        timeline.setOnFinished(e -> {
            App.stopPacmanController((PacmanController) getCloneObjectToModify());
            ((PacmanController) getCloneObjectToModify()).deinitialize();
            setCloneObjectToModify(null);

        });
    }

    private void goByFirstMapPoint(MovementManager movementManager)
    {
        Timeline timeline = movementManager.moveAnimate((int) firstMapPoint.getX() - OFFSET_LEFT, (int) firstMapPoint.getY(), movementManager.getObjectToMove());
        movementManager.getObjectToMove().getCollider().translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() < (firstMapPoint.getX() - OFFSET_LEFT + movementManager.getObjectToMove().getWidth())) {
                    if (getCloneObjectToModify() == null) {
//                        timeline.stop();
//                        return;
                        initAndStartCloneObjectToReflectPoint();
                    }
                }
            }
        });
        timeline.setOnFinished(event -> {
            System.out.println("finish mirror");
            App.stopPacmanController((PacmanController) getObjectControllerToModify());
            App.getPacmanController().deinitialize();
            App.setPacmanController((PacmanController) cloneObjectToModify);

        });
    }

    private void goByReflectiveMapPoint(MovementManager movementManager)
    {
        Timeline timeline = movementManager.moveAnimate((int) reflectiveMapPoint.getX() + OFFSET_RIGHT, (int) reflectiveMapPoint.getY(), movementManager.getObjectToMove());
        movementManager.getObjectToMove().getCollider().translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() > (reflectiveMapPoint.getX() + OFFSET_RIGHT - (movementManager.getObjectToMove().getWidth()))) {
                    if (getCloneObjectToModify() == null) {
                        initAndStartCloneObjectToFirstPoint();
                    }

                }
            }
        });
        timeline.setOnFinished(event -> {
            System.out.println("finish mirror");
            App.stopPacmanController((PacmanController) getObjectControllerToModify());
            App.getPacmanController().deinitialize();
            App.setPacmanController((PacmanController) cloneObjectToModify);

        });
    }

    private void initAndStartCloneObjectToFirstPoint()
    {
        try {
            cloneObjectToModify = createCloneObject(getObjectControllerToModify());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        System.out.println(getObjectControllerToModify().getMovementManager().getCurrentDirection());
        cloneObjectToModify.getControlledObject().setPoint(firstMapPoint);
        cloneObjectToModify.getControlledObject().moveLeft( OFFSET_LEFT );
        cloneObjectToModify.getControlledObject().updatePosition();
        cloneObjectToModify.initialize();
        cloneObjectToModify.getMovementManager().setCurrentPoint(firstMapPoint);

        updateDirectionInCloneObject(getObjectControllerToModify());

        startObject();
    }

    private void initAndStartCloneObjectToReflectPoint()
    {
        try {
            cloneObjectToModify = createCloneObject(getObjectControllerToModify());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        System.out.println(getObjectControllerToModify().getMovementManager().getCurrentDirection());
        cloneObjectToModify.initialize();
        cloneObjectToModify.getControlledObject().setPoint(reflectiveMapPoint);
        cloneObjectToModify.getControlledObject().moveRight(OFFSET_RIGHT);
        cloneObjectToModify.getControlledObject().updatePosition();
        cloneObjectToModify.getMovementManager().setCurrentPoint(reflectiveMapPoint);

        updateDirectionInCloneObject(getObjectControllerToModify());

        startObject();

    }

    private void startObject()
    {
        Platform.runLater(new Runnable() {
            public void run() {
//                            cloneObjectToModify.playMainAnimation();
                cloneObjectToModify.getControlledObject().setSelectFirstPoint(true);
                cloneObjectToModify.startMove();
                ((PacmanController)cloneObjectToModify).startEatAnimation();
                cloneObjectToModify.getMovementManager().run();
                App.startPacmanController((PacmanController)cloneObjectToModify);
            }
        });
    }

    private Controller createCloneObject(Controller objectToModify) throws CloneNotSupportedException {
        if (objectToModify instanceof PacmanController) {
            return (Controller) ((PacmanController) objectToModify).clone();
        }

        return null;
    }

    private void updateDirectionInCloneObject(Controller baseController)
    {
        if (baseController.getMovementManager().isTurnedTo(Direction.UP)) {
            System.out.println(baseController.getMovementManager().getCurrentDirection());
            System.out.println("UP");
            getCloneObjectToModify().getMovementManager().setCurrentDirection(Direction.UP);
            getCloneObjectToModify().getControlledObject().turnUp();
            getCloneObjectToModify().getControlledObject().setCheckedDirection(Direction.UP);
        } else if (baseController.getMovementManager().isTurnedTo(Direction.DOWN)) {
            getCloneObjectToModify().getMovementManager().setCurrentDirection(Direction.DOWN);
            getCloneObjectToModify().getControlledObject().turnDown();
            getCloneObjectToModify().getControlledObject().setCheckedDirection(Direction.DOWN);
        } else if (baseController.getMovementManager().isTurnedTo(Direction.LEFT)) {
            System.out.println("LEFT");

            getCloneObjectToModify().getMovementManager().setCurrentDirection(Direction.LEFT);
            getCloneObjectToModify().getControlledObject().turnLeft();
            getCloneObjectToModify().getControlledObject().setCheckedDirection(Direction.LEFT);
        } else if (baseController.getMovementManager().isTurnedTo(Direction.RIGHT)) {
            getCloneObjectToModify().getMovementManager().setCurrentDirection(Direction.RIGHT);
            getCloneObjectToModify().getControlledObject().turnRight();
            getCloneObjectToModify().getControlledObject().setCheckedDirection(Direction.RIGHT);

        }
    }

    public Controller getCloneObjectToModify() {
        return cloneObjectToModify;
    }

    public void setCloneObjectToModify(Controller cloneObjectToModify) {
        this.cloneObjectToModify = cloneObjectToModify;
    }

    @Override
    public void startAction() {

    }

    @Override
    public void endAction() {

    }
}
