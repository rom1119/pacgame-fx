package com.pacgame.game.board.model;

import com.pacgame.game.board.application.IMovement;
import com.pacgame.game.event.board.BoardElementMove;
import com.pacgame.game.event.board.GameBoardEventHandler;

public interface Moveable {

    void startMove();
    void stopMove();

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    void initMovementSystem(IMovement movement);
}
