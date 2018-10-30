package com.pacgame.move.type;

import com.pacgame.move.direction.IMoveDown;
import com.pacgame.move.direction.IMoveLeft;
import com.pacgame.move.direction.IMoveRight;
import com.pacgame.move.direction.IMoveUp;

public interface IStepMove extends
        IMoveDown ,
        IMoveUp,
        IMoveLeft,
        IMoveRight
{
}
