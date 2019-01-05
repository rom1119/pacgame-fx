package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;

import java.util.List;

public interface BoardMap {
    List<IMapPoint> createPoints();

    void addPacman(IPacman pacman);

    IMapPoint getPacmanInitPosition();

    IMapPoint getMazeInitPosition();

    void addMaze(IMaze maze);

    ILayer getView();
}
