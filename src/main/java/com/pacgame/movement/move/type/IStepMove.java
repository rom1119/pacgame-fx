package com.pacgame.movement.move.type;

import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.move.IMove2D;

public interface IStepMove extends IMove2D
{
    @Override
    void move(ObjectMoving2D objectMoving);
}
