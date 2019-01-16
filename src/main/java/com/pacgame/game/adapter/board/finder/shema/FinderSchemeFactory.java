package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.board.model.Moveable;

public class FinderSchemeFactory {

    public MazeFinderSchema createMazeFinderSchema(Moveable finderObject)
    {
        return new MazeFinderSchema(finderObject);
    }
}
