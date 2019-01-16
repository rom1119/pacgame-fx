package com.pacgame.game.adapter.board.finder.rules;

import com.pacgame.finder.FindPoint;
import com.pacgame.finder.FinderRule;
import com.pacgame.game.adapter.board.finder.FindPoint2DAdapter;

public class DoorCloseRule implements FinderRule {
    @Override
    public boolean isSatisfied(FindPoint point) {
        return !((FindPoint2DAdapter) point).isDoor();
    }
}
