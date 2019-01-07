package com.pacgame.game.board.model;

import com.pacgame.game.board.application.IMovement;

public interface Moveable {

    void startMove();
    void stopMove();

    void turnUp();
    void turnDown();
    void turnLeft();
    void turnRight();

    void initMovementSystem(IMovement movement);
}
