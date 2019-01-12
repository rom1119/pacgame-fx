package com.pacgame.game.board.model.pacman;

import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.exception.EatYourSelfException;

public interface IPacman extends Eatable, Moveable, BoardObject {

    void addScore(int score);

    void eat(Eatable eatableEl) throws EatYourSelfException;


    void setBoardEventFacade(BoardEventFacade boardEventFacade);
}
