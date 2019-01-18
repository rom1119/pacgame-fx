package com.pacgame.game.adapter.board;

import com.pacgame.Layer;
import com.pacgame.event.EventFacade;
import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.adapter.board.finder.FinderAdapter;
import com.pacgame.game.adapter.board.finder.FinderFactory;
import com.pacgame.game.adapter.board.finder.ObjectToFindFactory;
import com.pacgame.game.adapter.board.finder.rules.NotTurnAroundRule;
import com.pacgame.game.adapter.board.finder.shema.FinderSchemeFactory;
import com.pacgame.game.adapter.board.finder.shema.MazeFinderSchema;
import com.pacgame.game.adapter.board.movement.Movement2DAdapter;
import com.pacgame.game.adapter.board.movement.MovementFactory;
import com.pacgame.game.adapter.board.point.GamePointsFactory;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.gameElement.MovingElementFactory;
import com.pacgame.gameElement.standElement.GamePoint;
import com.pacgame.map.Level;
import com.pacgame.map.point.MapPoint;
import com.pacgame.scheme.SchemeStep;

import java.util.List;

public class BoardMapAdapter extends LayerAdapter implements BoardMap {

    private Level levelProvidedObject;
    private MovingElementFactory movingElementFactory;
    private ObjectToFindFactory objectToFindFactory;
    private FinderSchemeFactory finderSchemeFactory;
    private MapPointsCreator mapPointsCreator;
    private GamePointsFactory gamePointsCreator;
    private EventFacade eventFacade;

    private MovementFactory movementFactory;
    private FinderFactory finderFactory;

    private PacmanAdapter controlledPacman;
    private MazeAdapter mazeAdapter;



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
//                mazeAdapter.moveUp();
                controlledPacman.moveUp();
            } else if (e.isArrowBottom()) {
//                mazeAdapter.moveDown();
                controlledPacman.moveDown();
            } else if (e.isArrowLeft()) {
//                mazeAdapter.moveLeft();
                controlledPacman.moveLeft();
            } else if (e.isArrowRight()) {
//                mazeAdapter.moveRight();
                controlledPacman.moveRight();
            }
        });

    }

    public void setObjectToFindFactory(ObjectToFindFactory objectToFindFactory) {
        this.objectToFindFactory = objectToFindFactory;
    }

    public void setFinderSchemeFactory(FinderSchemeFactory finderSchemeFactory) {
        this.finderSchemeFactory = finderSchemeFactory;
    }

    public void setMovementFactory(MovementFactory movementFactory) {
        this.movementFactory = movementFactory;
        this.movementFactory.createMovePoints(mapPointsCreator.getAllPoints());
    }

    public void setFinderFactory(FinderFactory finderFactory) {
        this.finderFactory = finderFactory;
//        this.movementFactory.createMovePoints(mapPointsCreator.getAllPoints());
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
        ((PacmanAdapter) pacman).setMapPointsCreator(mapPointsCreator);

//        movementSystem.addRule(new DoorCloseRule());
        ((PacmanAdapter) pacman).onMoveDirectionChange(movementSystem.getEventFacade());
        controlledPacman = (PacmanAdapter) pacman;
    }



    @Override
    public void addMaze(IMaze maze) {
        levelProvidedObject.getRootLayer().addChildren(((MazeAdapter) maze).getProvidedObject());
        Movement2DAdapter movementSystem = movementFactory.createMovementSystem(getMazeInitPosition(), (MazeAdapter) maze);
        maze.initMovementSystem(movementSystem);
//        movementSystem.addRule(new DoorCloseRule());
        ((MazeAdapter) maze).setMapPointsCreator(mapPointsCreator);
        FinderAdapter finder = finderFactory.createFinder();
        maze.initFinder(finder);
        finder.init(maze);

        MazeFinderSchema mazeFinderSchema = finderSchemeFactory.createMazeFinderSchema(maze);

//        first step
        IMapPoint mazeInitPosition = getMazeInitPosition();
        ObjectToFind2D firstObject = objectToFindFactory.createObjectToFind2D(mazeInitPosition);

        SchemeStep schemeStep1 = mazeFinderSchema.setObjectForFirstStep(firstObject);


//        second step

        MapPoint point = levelProvidedObject.getAllMapPoints().get("d5A");
        IMapPoint fromPosition = mapPointsCreator.getFromPosition(point.getX(), point.getY());
        ObjectToFind2D secondObject = objectToFindFactory.createObjectToFind2D(fromPosition);

        SchemeStep schemeStep2 = mazeFinderSchema.setObjectForSecondStep(secondObject);




//        third step
        ObjectToFind2D thirdObject = objectToFindFactory.createObjectToFind2D((Moveable) controlledPacman);
        SchemeStep schemeStep3 = mazeFinderSchema.setObjectForThirdStep(thirdObject);
        schemeStep3.setOnComplete((() -> {
            mazeFinderSchema.toFirstStep();
        }));


        ((MazeAdapter) maze).setFinderScheme(mazeFinderSchema.getFinderScheme());



        mazeAdapter = (MazeAdapter) maze;
        ((MazeAdapter) maze).onMoveDirectionChange(movementSystem.getEventFacade());

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
