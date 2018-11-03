package com.pacgame.gameElement.movingElement;

import com.pacgame.gameElement.MovedComponent;
import com.pacgame.gameElement.Valuable;

public abstract class Maze extends MovedComponent implements Valuable {

    protected int value = 10;

    public Maze(int width, int height) {
        super(width, height);
    }

    @Override
    public int getValue() {
        return value;
    }
}
