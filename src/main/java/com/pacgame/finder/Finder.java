package com.pacgame.finder;

public interface Finder {

    void find(ObjectToFind objectToFind);

    void addRule(FinderRule rule);

    void removeRule(FinderRule rule);
}
