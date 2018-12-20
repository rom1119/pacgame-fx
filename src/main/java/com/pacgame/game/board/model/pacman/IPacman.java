package com.pacgame.game.board.model.pacman;

import com.pacgame.game.Eatable;
import com.pacgame.game.event.Target;
import com.pacgame.game.exception.EatYourSelfException;

public interface IPacman extends Eatable {

    void addScore(int score);

    void eat(Eatable eatableEl) throws EatYourSelfException;
}
