package com.pacgame.game.adapter.board;

import com.pacgame.event.EventFacade;
import com.pacgame.finder.Finder;
import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.adapter.ValueObject;
import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.gameElement.movingElement.Maze;
import com.pacgame.movement.impl.pointToPoint.event.MoverBetweenPointsEventFacade;
import com.pacgame.scheme.Scheme;

public class MazeAdapter extends GameElement implements IMaze {

    private Maze providedObject;
    private IMovement movement;
    private IMapPoint currentPositionPoint;
    private ValueObject<IMapPoint> currentPositionPointValueObject;

    private MapPointsCreator mapPointsCreator;
    private Finder finder;
    private ObjectToFind2D objectToFind;
    private Scheme<ObjectToFind2D> finderScheme;

    public MazeAdapter(Maze providedObject, EventFacade eventFacade) {
        this.providedObject = providedObject;
        this.currentPositionPointValueObject = new ValueObject<>();
    }

    @Override
    public int getValue() {
        return providedObject.getValue();
    }

    @Override
    public void changeToEaten() {

    }

    @Override
    public void setPosition(IMapPoint position) {
        providedObject.setX(position.getX());
        providedObject.setY(position.getY());
        setCurrentPoint(position);
        if (movement !=  null) {
            movement.skipTo(position);
        }
    }

    @Override
    public void changeToNormalCharacter() {

    }

    @Override
    public void initFinder(Finder finder) {
        this.finder = finder;
    }

    @Override
    public Maze getProvidedObject() {
        return providedObject;
    }

    @Override
    public void startMove() {
        if (movement != null) {
            movement.start();

        }
    }

    @Override
    public void stopMove() {
        if (movement != null) {
            movement.stop();

        }
    }

    public void setMapPointsCreator(MapPointsCreator mapPointsCreator) {
        this.mapPointsCreator = mapPointsCreator;
    }

    public void setObjectToFind(ObjectToFind2D objectToFind) {
        this.objectToFind = objectToFind;
    }

    @Override
    public void moveUp() {
        movement.moveUp();
    }

    @Override
    public void moveDown() {
        movement.moveDown();
    }

    @Override
    public void moveLeft() {
        movement.moveLeft();
    }

    @Override
    public void moveRight() {
        movement.moveRight();
    }

    @Override
    public IMapPoint getCurrentPoint() {
        return currentPositionPoint;
    }

    @Override
    public void setCurrentPoint(IMapPoint point) {
        currentPositionPoint = point;
        currentPositionPointValueObject.setValue(point);
    }

    public void onMoveDirectionChange(MoverBetweenPointsEventFacade movementEventFacade) {
        MazeAdapter mazeAdapter = this;

        movementEventFacade.addEventHandler(movementEventFacade.onMoveUpEvent(), event -> {
            providedObject.turnUp();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveLeftEvent(), event -> {
            providedObject.turnLeft();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveDownEvent(), event -> {
            providedObject.turnDown();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onMoveRightEvent(), event -> {
            providedObject.turnRight();

        });

        movementEventFacade.addEventHandler(movementEventFacade.onAnyMoveEndEvent(), event -> {
            setCurrentPoint(mapPointsCreator.getFromPosition(event.getX(), event.getY()));
//            System.out.println("q123");
            System.out.println(((MapPointAdapter) getCurrentPoint()).getName());
//            System.out.println(((MapPointAdapter) getCurrentPoint()).getUp());
//            System.out.println(((MapPointAdapter) getCurrentPoint()).getDown());
//            System.out.println(((MapPointAdapter) getCurrentPoint()).getLeft());
//            System.out.println(((MapPointAdapter) getCurrentPoint()).getRight());
//            System.out.println("q123");
            objectToFind = finderScheme.check();
            System.out.println(objectToFind.getPoint().getX());
            System.out.println(objectToFind.getPoint().getY());
            this.finder.find(objectToFind);

        });
    }

    @Override
    public void initMovementSystem(IMovement movement) {
        this.movement = movement;
    }

    @Override
    public boolean touching(BoardObject el) {
        return getProvidedObject().touching(((GameElement) el).getProvidedObject());
    }

    public void setFinderScheme(Scheme finderScheme) {
        this.finderScheme = finderScheme;
    }

    public ValueObject<IMapPoint> getCurrentPointValueObject() {
        return currentPositionPointValueObject;
    }
}
