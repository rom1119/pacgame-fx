package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.IView;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;

public interface BoardMap {
    void createPoints();

    void addPacman(IPacman pacman);

    IMapPoint getPacmanInitPosition();

    IMapPoint getMazeInitPosition();

    void addMaze(IMaze maze);

    ILayer getView();
}
