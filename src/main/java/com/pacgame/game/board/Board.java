package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.IView;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.property.ObservableList;

public class Board {

    private BoardMap map;
    private ObservableList<IPacman> pacmanList;
    private ObservableList<IMaze> mazeList;
    private ObservableList<IPoint> pointList;

    public Board(BoardMap map) {
        this.map = map;
        this.pacmanList = new ObservableList<>();
        this.mazeList = new ObservableList<>();
        this.pointList = new ObservableList<>();
    }

    public void initMapPoints()
    {
        map.createPoints();
    }

    public void initPacman(IPacman pacman)
    {
        map.addPacman(pacman);
        pacmanList.add(pacman);
        pacman.setPosition(map.getPacmanInitPosition());
    }

    public void initMaze(IMaze maze)
    {
        map.addMaze(maze);
        mazeList.add(maze);
        maze.setPosition(map.getMazeInitPosition());
    }


    public ILayer getView() {
        return map.getView();
    }
}