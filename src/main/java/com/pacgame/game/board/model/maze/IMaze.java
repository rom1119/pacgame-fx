package com.pacgame.game.board.model.maze;

import com.pacgame.game.Eatable;
import com.pacgame.game.event.Target;

public interface IMaze extends Eatable {

    int getValue();

    void changeToNormalCharacter();
}
