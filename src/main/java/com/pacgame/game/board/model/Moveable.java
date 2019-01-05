package com.pacgame.game.board.model;

import com.pacgame.game.board.application.IMovement;

public interface Moveable {

    void startMove();
    void stopMove();

    void initMovementSystem(IMovement movement);
}
