package com.pacgame.game.event.board;

import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;

public interface PacmanTouchPoint extends GameBoardEvent {

    IPacman getPacman();

    IPoint getPoint();

}
