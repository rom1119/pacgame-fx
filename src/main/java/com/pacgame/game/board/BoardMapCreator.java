package com.pacgame.game.board;

import com.pacgame.game.ILayer;
import com.pacgame.game.board.BoardMap;

public interface BoardMapCreator {

    BoardMap createMap(ILayer layer, int width, int height);
}
