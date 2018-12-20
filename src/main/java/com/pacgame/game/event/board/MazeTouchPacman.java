package com.pacgame.game.event.board;

import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;

public interface MazeTouchPacman extends GameBoardEvent {

    IMaze getMaze();

    IPacman getPacman();
}
