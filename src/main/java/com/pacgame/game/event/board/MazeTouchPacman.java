package com.pacgame.game.event.board;

import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.event.Event;

public interface MazeTouchPacman extends Event {

    IMaze getMaze();

    IPacman getPacman();
}
