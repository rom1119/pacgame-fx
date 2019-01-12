package com.pacgame.game.adapter.board;

import com.pacgame.Layer;
import com.pacgame.event.EventFacade;
import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.adapter.board.movement.Movement2DAdapter;
import com.pacgame.game.adapter.board.movement.MovementFactory;
import com.pacgame.game.adapter.board.movement.rules.DoorCloseRule;
import com.pacgame.game.adapter.board.point.GamePointsFactory;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.gameElement.MovingElementFactory;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.map.Level;
import com.pacgame.map.point.MapPoint;

import java.util.List;

public class BoardMapAdapter extends LayerAdapter implements BoardMap {

    private Level levelProvidedObject;
    private MovingElementFactory movingElementFactory;
    private MapPointsCreator mapPointsCreator;
    private GamePointsFactory gamePointsCreator;
    private EventFacade eventFacade;

    private MovementFactory movementFactory;

    private PacmanAdapter controlledPacman;


    public BoardMapAdapter(Level levelProvidedObject, MovingElementFactory movingElementFactory, EventFacade eventFacade) {
        this.levelProvidedObject = levelProvidedObject;
        this.movingElementFactory = movingElementFactory;
        this.eventFacade = eventFacade;
        this.mapPointsCreator = new MapPointsCreator();
        this.mapPointsCreator.createListMovePoints(levelProvidedObject.getAllMapPoints());
        this.gamePointsCreator = new GamePointsFactory();

        onControllPacmanByUser();

    }

    private void onControllPacmanByUser()
    {
        this.levelProvidedObject.getRootLayer().addEventHandler(eventFacade.keyEventFacade().onKeyPressed(), e -> {
            if (e.isArrowUp()) {
                controlledPacman.moveUp();
            } else if (e.isArrowBottom()) {
                controlledPacman.moveDown();
            } else if (e.isArrowLeft()) {
                controlledPacman.moveLeft();
            } else if (e.isArrowRight()) {
                controlledPacman.moveRight();
            }
        });

    }

    public void setMovementFactory(MovementFactory movementFactory) {
        this.movementFactory = movementFactory;
        this.movementFactory.createMovePoints(mapPointsCreator.getAllPoints());
    }

    @Override
    public List<IPoint> createPoints() {
        List<GamePoint> gamePoints = levelProvidedObject.populatePoints();

        return gamePointsCreator.getAllPoints(gamePoints);

    }

    @Override
    public void addPacman(IPacman pacman) {
        levelProvidedObject.getRootLayer().addChildren(((PacmanAdapter) pacman).getProvidedObject());
        Movement2DAdapter movementSystem = movementFactory.createMovementSystem(getPacmanInitPosition(), (PacmanAdapter) pacman);
        pacman.initMovementSystem(movementSystem);
        movementSystem.addRule(new DoorCloseRule());
        ((PacmanAdapter) pacman).onMoveDirectionChange(movementSystem.getEventFacade());
        controlledPacman = (PacmanAdapter) pacman;
    }



    @Override
    public void addMaze(IMaze maze) {
        levelProvidedObject.getRootLayer().addChildren(((MazeAdapter) maze).getProvidedObject());
        maze.initMovementSystem(movementFactory.createMovementSystem(getMazeInitPosition(), (MazeAdapter) maze));
    }

    @Override
    public IMapPoint getPacmanInitPosition() {
        MapPoint point = levelProvidedObject.getAllMapPoints().get("h5");
        return mapPointsCreator.getFromPosition(point.getX(), point.getY());
    }

    @Override
    public IMapPoint getMazeInitPosition() {
        MapPoint point = levelProvidedObject.getAllMapPoints().get("e5");
        return mapPointsCreator.getFromPosition(point.getX(), point.getY());
    }


    @Override
    public ILayer getView() {
        return null;
    }

    @Override
    public Layer getProvidedObject() {
        return levelProvidedObject.getRootLayer();
    }
}
