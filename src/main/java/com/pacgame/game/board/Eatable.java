package com.pacgame.game.board;

import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.event.Target;

public interface Eatable extends Target {

    int getValue();

    void changeToEaten();

    void setPosition(IMapPoint pacmanInitPosition);


}
