package com.pacgame.movement.move;

import com.pacgame.movement.ObjectMoving2D;

public interface IMove2D {

    boolean canMove();

    void move(ObjectMoving2D objectMoving);
}
