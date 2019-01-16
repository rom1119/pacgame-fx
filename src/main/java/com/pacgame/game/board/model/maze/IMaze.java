package com.pacgame.game.board.model.maze;

import com.pacgame.finder.Finder;
import com.pacgame.game.board.BoardObject;
import com.pacgame.game.board.Eatable;
import com.pacgame.game.board.model.Moveable;

public interface IMaze extends Eatable, Moveable, BoardObject {

    int getValue();

    void changeToNormalCharacter();

    void initFinder(Finder finder);
}
