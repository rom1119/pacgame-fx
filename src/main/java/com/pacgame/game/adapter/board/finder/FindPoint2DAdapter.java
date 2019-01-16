package com.pacgame.game.adapter.board.finder;

import com.pacgame.finder.FindPoint2D;
import com.pacgame.finder.FinderRule;
import com.pacgame.game.adapter.board.MapPointAdapter;

import java.util.List;

public class FindPoint2DAdapter implements FindPoint2D {

    private MapPointAdapter el;

    public FindPoint2DAdapter(MapPointAdapter el) {
        this.el = el;
    }

    @Override
    public int getX() {
        return el.getX();
    }

    @Override
    public int getY() {
        return el.getY();
    }

    @Override
    public boolean isSatisfiedByRules(List<FinderRule> rules) {
        return rules.stream().allMatch(e -> e.isSatisfied(this));
    }

    public boolean isDoor()
    {
        return el.isDoor();
    }
}
