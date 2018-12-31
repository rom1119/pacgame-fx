package com.pacgame.game.board;

import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;

public interface GameObjectFactory {

    IPacman createPacman();

    IMaze createRandomMaze();
}
