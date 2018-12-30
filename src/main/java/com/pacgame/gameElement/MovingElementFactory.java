package com.pacgame.gameElement;

import com.pacgame.gameElement.movingElement.Maze;
import com.pacgame.gameElement.movingElement.Pacman;

public interface MovingElementFactory {

    Maze createRandomMaze();

    Pacman createPacman();
}
