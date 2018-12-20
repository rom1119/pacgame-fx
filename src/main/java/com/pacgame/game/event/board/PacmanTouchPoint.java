package com.pacgame.game.event.board;

import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.Event;

public interface PacmanTouchPoint extends Event {

    IPacman getPacman();

    IPoint getPoint();

}
