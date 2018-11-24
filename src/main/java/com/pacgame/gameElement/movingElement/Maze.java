package com.pacgame.gameElement.movingElement;

import com.pacgame.gameElement.MovedComponent;
import com.pacgame.gameElement.Valuable;
import com.pacgame.provider.ComponentProvidedObject;

public abstract class Maze extends MovedComponent implements Valuable {

    protected int value = 10;

    public Maze(int width, int height, ComponentProvidedObject providedObject) {
        super(width, height, providedObject);
    }


    @Override
    public int getValue() {
        return value;
    }
}
