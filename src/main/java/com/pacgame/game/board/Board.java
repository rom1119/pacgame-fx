package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.property.ObservableList;

import java.util.Optional;

public class Board {

    private BoardMap map;
    private ObservableList<IPacman> pacmanList;
    private ObservableList<IMaze> mazeList;
    private ObservableList<IPoint> pointList;
    private BoardEventFacade boardEventFacade;

    public Board(BoardMap map) {
        this.map = map;
        this.pacmanList = new ObservableList<>();
        this.mazeList = new ObservableList<>();
        this.pointList = new ObservableList<>();
    }

    public void initBoard(GameObjectFactory gameObjectFactory)
    {
        initMapPoints();
        initPacman(gameObjectFactory.createPacman());

        initMaze(gameObjectFactory.createRandomMaze());

    }

    void initMapPoints()
    {
        pointList.addAll(map.createPoints());
    }

    void initPacman(IPacman pacman)
    {
        map.addPacman(pacman);
        pacman.setPosition(map.getPacmanInitPosition());
        pacman.setBoardEventFacade(boardEventFacade);

        pacmanList.add(pacman);
        onPacmanMove(pacman);
        pacman.startMove();
    }

    IPoint boardElementTouchAnyPoint(BoardObject el)
    {
        return pointList.stream().filter(point ->
             el.touching(point)
        ).findAny()
        .orElse(null)
        ;
    }

    void onPacmanMove(IPacman pacman)
    {
        boardEventFacade.addEventHandler(boardEventFacade.onPacmanMove(), ev -> {
            IPoint point = boardElementTouchAnyPoint(pacman);
            if (point != null) {
                boardEventFacade.emitEvent(boardEventFacade.createPacmanTouchPoint(pacman, pacman, point));
                point.changeToEaten();
            }
        });
    }

    void initMaze(IMaze maze)
    {
        map.addMaze(maze);
        mazeList.add(maze);
        maze.setPosition(map.getMazeInitPosition());

    }


    public ILayer getView() {
        return map.getView();
    }

    public void setEventFacade(BoardEventFacade boardEventFacade) {
        this.boardEventFacade = boardEventFacade;
    }
}