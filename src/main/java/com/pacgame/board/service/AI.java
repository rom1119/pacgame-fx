package com.pacgame.board.service;

import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.board.model.MapPoint;

import java.util.*;

public class AI {

    private final int COUNT_FREE_STEPS = 10;
    private int step = 0;

    private MazeController observerController;
    private PacmanController observableController;

    private MovementManager observerMovementManager;
    private MovementManager observableMovementManager;

    private MapPoint currentObserverMapPoint;
    private MapPoint currentObservableMapPoint;


    public AI(MazeController observerController, PacmanController observableController) {
        this.observerController = observerController;
        this.observableController = observableController;

        this.observerMovementManager = observerController.getMovementManager();
        this.observableMovementManager = observableController.getMovementManager();

        initCurrentPoints();

    }

    private void incrementStep()
    {
        step++;
    }

    public void zeroSteps()
    {
        step = 0;
    }

    public void setObserverController(MazeController observerController) {
        this.observerController = observerController;
    }

    public PacmanController getObservableController() {
        return observableController;
    }

    public void setObservableController(PacmanController observableController) {
        this.observableController = observableController;
    }

    public MovementManager getObserverMovementManager() {
        return observerMovementManager;
    }

    public void setObserverMovementManager(MovementManager observerMovementManager) {
        this.observerMovementManager = observerMovementManager;
    }

    public MovementManager getObservableMovementManager() {
        return observableMovementManager;
    }

    public void setObservableMovementManager(MovementManager observableMovementManager) {
        this.observableMovementManager = observableMovementManager;
    }

    public MazeController getObserverController() {
        return observerController;
    }

    private void initCurrentPoints()
    {
        currentObserverMapPoint = this.getObserverMovementManager().getCurrentPoint();
        currentObservableMapPoint = this.getObservableMovementManager().getCurrentPoint();
    }

    public boolean selectNextDirectionToPacman()
    {
//System.out.println("maze : " + this.getObserverMovementManager().getCurrentPoint().getX());
//System.out.println("pacman : " + this.getObservableMovementManager().getCurrentPoint().getX());
        if (step <= COUNT_FREE_STEPS) {
            incrementStep();
            return false;
        }
        initCurrentPoints();

        Map<Integer, MapPoint> availablePoints = new HashMap<>();

        pushAvailableMapPointsWithoutDoor(availablePoints, false);

        while (availablePoints.size() < 1) {
            pushAvailableMapPointsWithoutDoor(availablePoints, true);
        }
        if (availablePoints.size() < 1) {
            throw new RuntimeException("not selected direction in AI");
        }

        int mostDirection = findMostDirection(availablePoints);
        turn(mostDirection);

        return true;
    }

    public boolean selectNextDirectionToInitPosition(String keyMapPoint)
    {
//System.out.println("maze : " + this.getObserverMovementManager().getCurrentPoint().getX());
//System.out.println("pacman : " + this.getObservableMovementManager().getCurrentPoint().getX());

        initCurrentPoints();
        this.currentObservableMapPoint = (MapPoint) MapPathCreator.getAllPoints().get(keyMapPoint);
//System.out.println(keyMapPoint);
        Map<Integer, MapPoint> availablePoints = new HashMap<>();

        pushAvailableMapPoints(availablePoints, false);

        while (availablePoints.size() < 1) {
            pushAvailableMapPoints(availablePoints, true);
        }
        if (availablePoints.size() < 1) {
            throw new RuntimeException("not selected direction in AI");
        }

        int mostDirection = findMostDirection(availablePoints);
        turn(mostDirection);

        return true;
    }

    private Map<Integer, MapPoint> pushAvailableMapPoints(Map<Integer, MapPoint> availablePoints, boolean withBackDirection)
    {
        if (canTurn(Direction.UP, withBackDirection)) {
            availablePoints.put(Direction.UP, currentObserverMapPoint.getUpPoint());
        }

        if (canTurn(Direction.DOWN, withBackDirection)) {
            availablePoints.put(Direction.DOWN, currentObserverMapPoint.getDownPoint());
        }

        if (canTurn(Direction.LEFT, withBackDirection)) {
            availablePoints.put(Direction.LEFT, currentObserverMapPoint.getLeftPoint());
        }

        if (canTurn(Direction.RIGHT, withBackDirection)) {
            availablePoints.put(Direction.RIGHT, currentObserverMapPoint.getRightPoint());
        }

        return availablePoints;
    }

    private Map<Integer, MapPoint> pushAvailableMapPointsWithoutDoor(Map<Integer, MapPoint> availablePoints, boolean withBackDirection)
    {
        if (canTurnWithoutDoor(Direction.UP, withBackDirection)) {
            availablePoints.put(Direction.UP, currentObserverMapPoint.getUpPoint());
        }

        if (canTurnWithoutDoor(Direction.DOWN, withBackDirection)) {
            availablePoints.put(Direction.DOWN, currentObserverMapPoint.getDownPoint());
        }

        if (canTurnWithoutDoor(Direction.LEFT, withBackDirection)) {
            availablePoints.put(Direction.LEFT, currentObserverMapPoint.getLeftPoint());
        }

        if (canTurnWithoutDoor(Direction.RIGHT, withBackDirection)) {
            availablePoints.put(Direction.RIGHT, currentObserverMapPoint.getRightPoint());
        }

        return availablePoints;
    }

    private int findMostDirection(Map<Integer, MapPoint> availableMapPoints)
    {
        Map<Integer, Integer> calculateWays = new HashMap<>();

        for(Map.Entry<Integer, MapPoint> entry : availableMapPoints.entrySet()) {
            Integer key = entry.getKey();
            MapPoint value = entry.getValue();

            int calculate = (int) Math.sqrt(Math.pow((currentObservableMapPoint.getX() - value.getX()), 2) + Math.pow((currentObservableMapPoint.getY() - value.getY()), 2));


            calculateWays.put(key, calculate);

            // do what you have to do here
            // In your case, another loop.
        }

        if (calculateWays.size() == 0) {
            System.out.println("aasdasdads");
        }


        Map.Entry<Integer, Integer> min = Collections.min(calculateWays.entrySet(), new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        return min.getKey();
    }


    protected boolean canTurn(int direction, boolean withBackDirection)
    {
        if (getObserverController().getMovementManager().getCurrentPoint() == null) {
            return false;
        }
//        System.out.println("prev" + getObserverController().getMovementManager().getCurrentDirection());
//        System.out.println("dir" + direction);

        if (withBackDirection) {
            switch (direction) {
                case Direction.UP :

                    return getObserverController().getMovementManager().getCurrentPoint().getUpPoint() != null
                            ;

                case Direction.DOWN :

                    return getObserverController().getMovementManager().getCurrentPoint().getDownPoint() != null
                            ;

                case Direction.LEFT :

                    return getObserverController().getMovementManager().getCurrentPoint().getLeftPoint() != null
                            ;

                case Direction.RIGHT :
                    return getObserverController().getMovementManager().getCurrentPoint().getRightPoint() != null
                            ;

            }
        } else {
            switch (direction) {
                case Direction.UP :

                    return getObserverController().getMovementManager().getCurrentPoint().getUpPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.DOWN
                            ;

                case Direction.DOWN :

                    return getObserverController().getMovementManager().getCurrentPoint().getDownPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.UP
                            ;

                case Direction.LEFT :

                    return getObserverController().getMovementManager().getCurrentPoint().getLeftPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.RIGHT
                            ;

                case Direction.RIGHT :
                    return getObserverController().getMovementManager().getCurrentPoint().getRightPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.LEFT
                            ;

            }
        }


        return false;

    }

    protected boolean canTurnWithoutDoor(int direction, boolean withBackDirection)
    {
        if (getObserverController().getMovementManager().getCurrentPoint() == null) {
            return false;
        }
//        System.out.println("prev" + getObserverController().getMovementManager().getCurrentDirection());
//        System.out.println("dir" + direction);

        if (withBackDirection) {
            switch (direction) {
                case Direction.UP :

                    return getObserverController().getMovementManager().getCurrentPoint().getUpPoint() != null
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getUpPoint().isDoor()
                            ;

                case Direction.DOWN :

                    return getObserverController().getMovementManager().getCurrentPoint().getDownPoint() != null
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getDownPoint().isDoor()
                            ;

                case Direction.LEFT :

                    return getObserverController().getMovementManager().getCurrentPoint().getLeftPoint() != null
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getLeftPoint().isDoor()
                            ;

                case Direction.RIGHT :
                    return getObserverController().getMovementManager().getCurrentPoint().getRightPoint() != null
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getRightPoint().isDoor()
                            ;

            }
        } else {
            switch (direction) {
                case Direction.UP :

                    return getObserverController().getMovementManager().getCurrentPoint().getUpPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.DOWN
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getUpPoint().isDoor()
                            ;

                case Direction.DOWN :

                    return getObserverController().getMovementManager().getCurrentPoint().getDownPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.UP
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getDownPoint().isDoor()
                            ;

                case Direction.LEFT :

                    return getObserverController().getMovementManager().getCurrentPoint().getLeftPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.RIGHT
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getLeftPoint().isDoor()
                            ;

                case Direction.RIGHT :
                    return getObserverController().getMovementManager().getCurrentPoint().getRightPoint() != null
                            &&
                            getObserverController().getMovementManager().getCurrentDirection() != Direction.LEFT
                            &&
                            !getObserverController().getMovementManager().getCurrentPoint().getRightPoint().isDoor()
                            ;

            }
        }


        return false;

    }

    private void turn(int direction)
    {
        this.getObserverController().getControlledObject().setCheckedDirection(direction);
    }



}
