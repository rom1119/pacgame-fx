package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.board.model.Moveable;
import com.pacgame.game.board.model.maze.IMaze;

public class FinderSchemeFactory {

    public MazeFinderSchema createMazeFinderSchema(IMaze finderObject)
    {
        return new MazeFinderSchema(finderObject);
    }
}
