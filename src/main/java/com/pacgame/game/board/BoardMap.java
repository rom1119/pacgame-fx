package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;

import java.util.List;

public interface BoardMap {
    List<IPoint> createPoints();

    void addPacman(IPacman pacman);

    IMapPoint getPacmanInitPosition();

    IMapPoint getMazeInitPosition();

    void addMaze(IMaze maze);

    ILayer getView();
}
