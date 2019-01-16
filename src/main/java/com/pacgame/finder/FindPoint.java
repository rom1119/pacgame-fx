package com.pacgame.finder;

import java.util.List;

public interface FindPoint {

    int getX();
    int getY();

    boolean isSatisfiedByRules(List<FinderRule> rules);
}
