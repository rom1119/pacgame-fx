package com.pacgame.game.board.model.maze;

import com.pacgame.game.board.Eatable;

public interface IMaze extends Eatable {

    int getValue();

    void changeToNormalCharacter();
}
