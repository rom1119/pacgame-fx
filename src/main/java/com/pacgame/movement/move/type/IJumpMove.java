package com.pacgame.movement.move.type;

import com.pacgame.movement.move.direction.IMoveDown;
import com.pacgame.movement.move.direction.IMoveLeft;
import com.pacgame.movement.move.direction.IMoveRight;
import com.pacgame.movement.move.direction.IMoveUp;

public interface IJumpMove extends
        IMoveDown,
        IMoveUp,
        IMoveLeft,
        IMoveRight
{
}
