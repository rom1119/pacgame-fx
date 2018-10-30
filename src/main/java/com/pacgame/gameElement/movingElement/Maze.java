package com.pacgame.gameElement.movingElement;

import com.pacgame.gameElement.MovedComponent;
import com.pacgame.gameElement.Valuable;

public abstract class Maze extends MovedComponent implements Valuable {

    protected int value = 10;

    @Override
    public int getValue() {
        return value;
    }
}
