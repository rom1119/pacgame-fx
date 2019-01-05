package com.pacgame.game.board.model.maze;

import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.model.Moveable;

public interface IMaze extends Eatable, Moveable {

    int getValue();

    void changeToNormalCharacter();
}
