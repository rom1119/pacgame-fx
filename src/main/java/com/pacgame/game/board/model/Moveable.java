package com.pacgame.game.board.model;

import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.event.board.BoardElementMove;
import com.pacgame.game.event.board.GameBoardEventHandler;

public interface Moveable {

    void startMove();
    void stopMove();

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    IMapPoint getCurrentPoint();
    void setCurrentPoint(IMapPoint point);

    void initMovementSystem(IMovement movement);
}
